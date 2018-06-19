package com.spring.boot.core;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TimeFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("===========初始化过滤器===========");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		long start = System.currentTimeMillis();
		chain.doFilter(request, response);
		System.out.println("filter耗时:" + (System.currentTimeMillis() - start) + "ms");
	}

	@Override
	public void destroy() {
		System.out.println("============销毁过滤器===========");
	}

}
