package com.unycom.shopping.demo.controller;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CORSFilter extends CorsFilter {

	public CORSFilter(@Qualifier("mvcHandlerMappingIntrospector") CorsConfigurationSource source) {
		super((CorsConfigurationSource) source);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Headers",
				"Access-Control-Allow-Origin, Access-Control-Max-Age, Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
		response.addHeader("Access-Control-Allow-Origin", "*");
		filterChain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// no needed
	}

}
