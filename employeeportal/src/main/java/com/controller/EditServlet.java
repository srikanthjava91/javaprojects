package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.dao.EmployeeDAO;
import com.model.EmployeeDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");

		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);

		try {
			EmployeeDTO emp = EmployeeDAO.getEmployeeDetailsById(id1);

			out.print("<html>");
			out.print("<body bgcolor='lightgreen'>");
			out.print("<h1>Edit Employee Details </h1>");
			out.print("<form action='EditServlet2' method='post'>");
			out.println("<table border=1>");
			out.println("<tr>" + "<td>ID</td>" + "<td><input type='text' name='id' value=" + emp.getId()
					+ " ></td>" + "</tr>"

					+ "<tr>" + "<td>Firstname</td>" + "<td><input type='text' name='fname' value=" + emp.getFirstname()
					+ "></td>" + "</tr>"

					+ "<tr>" + "<td>Lastname</td>" + "<td><input type='text' name='lname' value=" + emp.getLastname()
					+ "></td>" + "</tr>"

					+ "<tr>" + "<td>Username</td>" + "<td><input type='text' name='uname' value=" + emp.getUsername()
					+ "></td>" + "</tr>"

					+ "<tr>" + "<td>Email</td>" + "<td><input type='text' name='email' value=" + emp.getEmail()
					+ "></td>" + "</tr>"

					+ "<tr>" + "<td>Password</td>" + "<td><input type='password' name='pass' value=" + emp.getPassword()
					+ "></td>" + "</tr>"

					+ "<tr>" + "<td>Phone number</td>" + "<td><input type='text' name='phone' value=" + emp.getPhone()
					+ "></td>" + "</tr>"

					+ "<tr>" + "<td>Age</td>" + "<td><input type='text' name='age' value=" + emp.getAge() + "></td>"
					+ "</tr>"

					+ "<tr>" + "<td>Country</td>" + "<td><input type='text' name='country' value=" + emp.getCountry()
					+ "></td>" + "<tr>"

					+ "<tr>" + "<td>City</td>" + "<td><input type='text' name='city' value=" + emp.getCity() + "></td>"
					+ "</tr>"

					+ "<tr>" + "<td>State</td>" + "<td><input type='text' name='state'  value=" + emp.getState()
					+ "></td>" + "</tr>"

			);
			out.print("</table>");
			out.print("<input type='submit' value='edit&Submit'>");

			out.println("</form>");
			out.print("</body>");
			out.print("</html>");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
