package com.emsws.init.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
/***
 * 
 * @author edelacruz
 *
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.emsws.employee"})
public class WebConfig extends WebMvcConfigurerAdapter {
	
	@Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        registry.viewResolver(viewResolver);
    }
	
	/***
	 * NOTE:
	 * THIS IS TO IMPORT STATIC FILES(LIKE CSS AND JAVASCRIPT) TO THE SPRING MVC VIEW(WEB-INF/pages/)
	 * EXAMPLE: <script src="/resources/js/lib/angular.min.js"></script>
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
       
    }

}
