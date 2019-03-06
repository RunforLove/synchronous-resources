package com.runforlove.synchronousresources.interceptor;

import com.runforlove.synchronousresources.constants.RequestConstants;
import com.runforlove.synchronousresources.utils.SystemUtils;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	/**
	 * This implementation always returns {@code true}.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String loginName = request.getHeader(RequestConstants.CURRENT_LOGIN_USERNAME);
		if (StringUtils.isEmpty(loginName)) {
			return false;
		}
		String deviceName = request.getHeader(RequestConstants.DEVICE_NAME);
		RequestContext
				requestContext =
				RequestContext.builder().name(loginName).remoteIp(SystemUtils.getRemoteIp(request)).deviceName(deviceName)
						.requestUrl(request.getRequestURL().toString()).build();
		ServiceContext.attach(requestContext);
		return true;
	}
	
	/**
	 * This implementation is empty.
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
	                       @Nullable ModelAndView modelAndView) throws Exception {
		ServiceContext.remove();
	}
	
	/**
	 * This implementation is empty.
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
	                            @Nullable Exception ex) throws Exception {
		ServiceContext.remove();
	}
	
}
