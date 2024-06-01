package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.dao.EmployeeDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("uname");
		String password = request.getParameter("pass");

		boolean status = EmployeeDAO.validateUserCredentials(username, password);

		if (status) {
			response.sendRedirect("welcome.html");
		} else {
			out.println("<font color='red'><b>You have entered incorrect password</b></font>");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}

	}

}
