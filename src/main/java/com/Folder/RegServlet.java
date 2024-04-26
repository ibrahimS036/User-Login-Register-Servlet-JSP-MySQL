package com.Folder;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class RegServlet extends HttpServlet {

	private static Connection con;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

		resp.setContentType("text/html");

		String newName = req.getParameter("name");
		String oldPassword = req.getParameter("password");
		String newEmail = req.getParameter("email");
		String newPhone = req.getParameter("phone");
		String newCity = req.getParameter("city");

		try {
			PrintWriter out = resp.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginmodule", "root", "goodtogo");
			String Query = ("insert into register_data (name,password,email,phonenumber,city) values(?,?,?,?,?)");
			PreparedStatement ps = con.prepareStatement(Query);
			ps.setString(1, newName);
			ps.setString(2, oldPassword);
			ps.setString(3, newEmail);
			ps.setString(4, newPhone);
			ps.setString(5, newCity);
			int result = ps.executeUpdate();
			HttpSession session = req.getSession();
			session.setAttribute("pswd", oldPassword);
			if (result > 0) {
				RequestDispatcher rd = req.getRequestDispatcher("log.html");
				rd.forward(req, resp);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
