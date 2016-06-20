package com.emsws.init.configuration;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
/***
 * 
 * @author edelacruz
 * 
 * This is to avoid issues regarding SAME ORIGIN POLICY.
 * 
 * ERROR LIKE:
 * No ‘Access-Control-Allow-Origin’ header is present on the requested resource.
 *
 */

public class CrossOriginResourceSharingFilter implements Filter {

	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletResponse responseObject = (HttpServletResponse) response;
        responseObject.setHeader("Access-Control-Allow-Origin", "*");
        responseObject.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        responseObject.setHeader("Access-Control-Max-Age", "3600");
        responseObject.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type, origin, authorization, accept, client-security-token");
        chain.doFilter(request, responseObject);
		
	}

	
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
