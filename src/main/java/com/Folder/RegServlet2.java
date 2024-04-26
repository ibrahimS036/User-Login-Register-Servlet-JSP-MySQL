package com.Folder;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



public class RegServlet2 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("username");
		String password = req.getParameter("userpassword");

		HttpSession session = req.getSession();
		String oldPassword = (String) session.getAttribute("pswd");

		if (oldPassword.equals(password)) {
			RequestDispatcher rd = req.getRequestDispatcher("Success.html");
			rd.forward(req, resp);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("Error.html");
			rd.forward(req, resp);
		}

	}

}
