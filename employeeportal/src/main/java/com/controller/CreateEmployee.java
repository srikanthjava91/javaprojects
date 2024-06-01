package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.dao.EmployeeDAO;
import com.model.EmployeeDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/create")
public class CreateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateEmployee() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);

		String phone = request.getParameter("phone");
		long phone1 = Long.parseLong(phone);

		String age = request.getParameter("age");
		int age1 = Integer.parseInt(age);

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String uname = request.getParameter("uname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String country = request.getParameter("country");
		String state = request.getParameter("state");
		String city = request.getParameter("city");

		EmployeeDTO emp = new EmployeeDTO();
		emp.setId(id1);
		emp.setAge(age1);
		emp.setPhone(phone1);

		emp.setFirstname(fname);
		emp.setLastname(lname);
		emp.setPassword(password);
		emp.setEmail(email);
		emp.setUsername(uname);
		emp.setCity(city);
		emp.setState(state);
		emp.setCountry(country);

		boolean status = EmployeeDAO.createEmployee(emp);

		if (status) {
			response.sendRedirect("success.html");
		}

	}

}
