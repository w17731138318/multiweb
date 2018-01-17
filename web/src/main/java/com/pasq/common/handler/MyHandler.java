package com.pasq.common.handler;

import com.pasq.config.WebMvcConfig;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 王伟鑫
 * @version 0.1v
 * @create 2018-01-17 11:23
 * @see HandlerInterceptorAdapter 创建拦截器，只需要继承HandlerInterceptorAdapter类接口，然后在spring boot配置类内将此拦截器添加到系统配置内即可
 * @see WebMvcConfig
 **/
@Component
public class MyHandler extends HandlerInterceptorAdapter {
	public MyHandler() {
		super();
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if(handler instanceof HandlerMethod) {
			System.out.println("进入拦截器");
		}else{
			return true;
		}

		//从header中获取token
		String token = request.getHeader("token");
		//如果header中不存在token，则从参数中获取token
		if(StringUtils.isBlank(token)){
			token = request.getParameter("token");
		}

		//token为空
		if(StringUtils.isBlank(token)){
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		super.afterConcurrentHandlingStarted(request, response, handler);
	}
}
