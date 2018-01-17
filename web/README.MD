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
                      