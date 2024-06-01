package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.dao.EmployeeDAO;
import com.model.EmployeeDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		List<EmployeeDTO> empDetails = EmployeeDAO.getAllEmployeeDetails();

		out.print("<html>");
		out.print("<body bgcolor='lightblue'>");
		out.print("<h1>Employee Details </h1>");
		out.print("<table border='1px'>");
		out.print("<th>ID</th> "
				+ "<th> First Name </th>"
				+ "<th> Last Name </th>"
				+ "<th> Password </th>"
				+ "<th> Username </th>"
				+ "<th> Email </th>"
				+ "<th> Phone </th>"
				+ "<th> Age </th>"
				+ "<th> City </th>"
				+ "<th> State </th>"
				+ "<th> Country </th>"
				+ "<th> Update </th>"
				+ "<th> Delete </th>");

		
		for (EmployeeDTO emp : empDetails) {
			out.print("<tr> "
					+ "<td>"+emp.getId() + "</td>"
					+ "<td>"+emp.getFirstname()+ "</td>"
					+ "<td>"+emp.getLastname()+ "</td>"
					+ "<td>"+emp.getUsername()+ "</td>"
					+ "<td>"+emp.getPassword()+ "</td>"
					+ "<td>"+emp.getEmail()+ "</td>"
					+ "<td>"+emp.getPhone()+ "</td>"
					+ "<td>"+emp.getAge()+ "</td>"
					+ "<td>"+emp.getCity()+ "</td>"
					+ "<td>"+emp.getState()+ "</td>"
					+ "<td>"+emp.getCountry()+ "</td>"
					+ "<td><a href='edit?id="+ emp.getId() +"'>edit</td>"
					+ "<td><a href='DeleteServlet?id="+ emp.getId() +"'>delete</td>"
					+"</tr>");
		}
		
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");


	}

}
