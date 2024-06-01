package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.dao.EmployeeDAO;
import com.model.EmployeeDTO;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

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
		String password = request.getParameter("pass");
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

		try {
			boolean status = EmployeeDAO.updateEmployee(emp);

			if (status) {
				response.sendRedirect("welcome.html");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
