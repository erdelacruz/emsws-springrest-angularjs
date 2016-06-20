package com.emsws.init;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.emsws.init.configuration.CrossOriginResourceSharingFilter;
import com.emsws.init.configuration.DataAccessConfig;
import com.emsws.init.configuration.WebConfig;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[]{WebConfig.class,DataAccessConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
	
	@Override
    protected Filter[] getServletFilters() {
        Filter [] singleton = { new CrossOriginResourceSharingFilter()};
        return singleton;
    }

}
