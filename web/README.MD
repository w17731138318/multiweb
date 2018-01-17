#spring boot过滤器和拦截器
##一、过滤器
###创建自定义过滤器
####传统方式（通过@Configuration类和FilterRegistrationBean添加过滤器）
1. 过滤器 xxFilter implements Filter类
2. 重写父类的doFilter方法
3. 创建配置类 @Configuration FilterConfig（类名随意，这里为了方便理解）
4. 在配置类内初始化@bean FilterRegistrationBean

>``@Bean
      public FilterRegistrationBean xxFilterRegistration() {
          FilterRegistrationBean registration = new FilterRegistrationBean();
          registration.setDispatcherTypes(DispatcherType.REQUEST);
          registration.setFilter(new xxFilter());
          registration.addUrlPatterns("/*");
          registration.setName("xxFilter");
          registration.setOrder(Integer.MAX_VALUE);
          return registration;
      }``
5. 其中 setFilter 添加过滤器
6. 其中 setOrder 设置执行过滤顺序，值越小，越先执行
####注解方式（@WebFilter和@Order添加过滤器）
1. 过滤器 xxFilter implements Filter类 另外需要再类上添加注解

>``@Order(1)
  @WebFilter(filterName = "xxFilter", urlPatterns = "/*")
  public class xxFilter implements Filter {
      @Override
      public void init(FilterConfig filterConfig) throws ServletException {
      }
      @Override
      public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
              throws IOException, ServletException {
          System.out.println("xxFilter");
          chain.doFilter(servletRequest,servletResponse);
      }
      @Override
      public void destroy() {
      }
  }``
2.  在spring boot 启动类上添加 @ServletComponentScan 即可

##拦截器
###创建自定义拦截器
在spring boot中创建自定义拦截器很简单只需要3步：
1. 创建我们自己的拦截器类并实现 HandlerInterceptor 接口或者继承 HandlerInterceptorAdapter 类。
2. 创建一个Java类继承WebMvcConfigurerAdapter，并重写 addInterceptors 方法。
3. 实例化我们自定义的拦截器，然后将对像手动添加到拦截器链中（在addInterceptors方法中添加）。

创建自己的拦截器
>``public class MyInterceptor implements HandlerInterceptor {
      @Override
      public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
              throws Exception {
          System.out.println(">>>>>在请求处理之前进行调用（Controller方法调用之前）");
          return true;
      }
      @Override
      public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
              ModelAndView modelAndView) throws Exception {
         System.out.println(">>>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
      }
      @Override
      public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
              throws Exception {
          System.out.println(">>>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
      }
  }``
  
实例化拦截器并添加到拦截器链中
``@Configuration
  public class MyWebAppConfigurer extends WebMvcConfigurerAdapter { @Override 
    public void addInterceptors(InterceptorRegistry registry) { 
      // 多个拦截器组成一个拦截器链 
      registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**"); 
      registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/rest/**");
      super.addInterceptors(registry); 
    }
  }``
  
##自定义注解创建 和 使用
在spring boot项目中创建注解，然后通过切面来实现注解,非常简单:

1. 创建注解
``@Documented
  @Retention(RUNTIME)
  @Target(METHOD)
  public @interface MyLog {
      String value() default "日志注解";
  }``
  
2. 通过切面来实现注解
``@Component
     @Aspect
     public class LogAspect {
         @Pointcut("@annotation(xx.xx.xx.MyLog)")
         private void cut() { }
         /**
          * 定制一个环绕通知
          * @param joinPoint
          */
         @Around("cut()")
         public void advice(ProceedingJoinPoint joinPoint){
             System.out.println("环绕通知之开始");
             try {
                 joinPoint.proceed();
             } catch (Throwable e) {
                 e.printStackTrace();
             }
             System.out.println("环绕通知之结束");
         }
         //当想获得注解里面的属性，可以直接注入改注解
         @Before("cut()&&@annotation(myLog)")
            public void record(JoinPoint joinPoint, MyLog myLog) {
            System.out.println(myLog.value());
         }
         @After("recordLog()")
         public void after() {
             this.printLog("已经记录下操作日志@After 方法执行后");
         }
     }``
     
3. 因为Aspect作用在bean上，所以先用Component把这个类添加到容器中
4. @Pointcut 定义要拦截的注解
