package com.spring.boot.core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ServletTest extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest reg, HttpServletResponse resp) throws ServletException, IOException{
		doPost(reg, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest reg, HttpServletResponse resp) throws ServletException, IOException{
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().write("自定义 Servlet");
	}
	
}
