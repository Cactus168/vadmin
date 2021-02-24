/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.vadmin.common.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author Grug
 * @date  2020/8/19 17:00
 */
public class HttpContextUtils {

	/**
	 * 获取Request
	 * @author Grug
	 * @date  2020/8/19 17:09
	 * @param 
	 * @return javax.servlet.http.HttpServletRequest
	 */
	public static HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}
    
	/**
	 * 获取
	 * @author Grug
	 * @date  2020/8/19 17:53
	 * @param 
	 * @return java.lang.String
	 */
	public static String getDomain(){
		HttpServletRequest request = getRequest();
		StringBuffer url = request.getRequestURL();
		return url.delete(url.length() - request.getRequestURI().length(), url.length()).toString();
	}
    /**
     * 获取站点信息
     * @author Grug
     * @date  2020/8/19 17:51
     * @param 
     * @return java.lang.String
     */
	public static String getOrigin(){
		HttpServletRequest request = getRequest();
		return request.getHeader("Origin");
	}
}
