package com.Folder;

import java.io.IOException;

import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyFilter implements Filter {

	public void doFilter1(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		PrintWriter out = httpResponse.getWriter();

		String city = httpRequest.getParameter("city");

		if ("Mumbai".equalsIgnoreCase(city)) {

			chain.doFilter(request, response);
		} else {

			out.println("<h1>Only users from Mumbai can Register...Thank You!</h1>");
		}
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}

}
