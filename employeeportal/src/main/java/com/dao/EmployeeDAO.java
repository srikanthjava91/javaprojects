package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.EmployeeDTO;

public class EmployeeDAO {

	/**
	 * 
	 * getConnection method is creating connection Object
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection con = null;
		System.out.println("Loading the driver class !!");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// create a connection Object
		System.out.println("Creating connection Object !!");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Oracle3");
		return con;
	}

	/**
	 * @param emp
	 * 
	 *            createEmployee method will take it, emp as a argument and
	 *            inserting the data into Data base
	 * 
	 * 
	 * @return
	 */
	public static boolean createEmployee(EmployeeDTO emp) {
		boolean status = false;

		try {
			Connection con = getConnection();
			String sql = "insert into employee5 values(?,?,?,?,?,?,?,?,?,?,?)";
			// Create PreparedStatements
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, emp.getId());
			pstmt.setString(2, emp.getFirstname());
			pstmt.setString(3, emp.getLastname());
			pstmt.setString(4, emp.getPassword());
			pstmt.setString(5, emp.getUsername());
			pstmt.setString(6, emp.getEmail());
			pstmt.setLong(7, emp.getPhone());
			pstmt.setInt(8, emp.getAge());
			pstmt.setString(9, emp.getCity());
			pstmt.setString(10, emp.getState());
			pstmt.setString(11, emp.getCountry());

			int i = pstmt.executeUpdate();

			if (i > 0) {
				status = true;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public static boolean validateUserCredentials(String username, String password) {
		boolean status = false;
		try {
			Connection con = getConnection();
			String sql = "select * from employee5 where username=? and password= ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				status = true;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return status;
	}

	public static List<EmployeeDTO> getAllEmployeeDetails() {
		List<EmployeeDTO> empList = new ArrayList<>();

		try {
			Connection con = getConnection();
			String sql = "select * from employee5";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				EmployeeDTO emp = new EmployeeDTO();
				emp.setId(rs.getInt(1));
				emp.setFirstname(rs.getString(2));
				emp.setLastname(rs.getString(3));
				emp.setPassword(rs.getString(4));
				emp.setUsername(rs.getString(5));
				emp.setEmail(rs.getString(6));
				emp.setPhone(rs.getLong(7));
				emp.setAge(rs.getInt(8));
				emp.setCity(rs.getString(9));
				emp.setState(rs.getString(10));
				emp.setCountry(rs.getString(11));
				empList.add(emp);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return empList;
	}

	public static EmployeeDTO getEmployeeDetailsById(int id1) throws ClassNotFoundException, SQLException {
		EmployeeDTO emp = new EmployeeDTO();
		Connection con = getConnection();
		String sql = "select * from employee5 where id =?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id1);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			emp.setId(rs.getInt(1));
			emp.setFirstname(rs.getString(2));
			emp.setLastname(rs.getString(3));
			emp.setPassword(rs.getString(4));
			emp.setUsername(rs.getString(5));
			emp.setEmail(rs.getString(6));
			emp.setPhone(rs.getLong(7));
			emp.setAge(rs.getInt(8));
			emp.setCity(rs.getString(9));
			emp.setState(rs.getString(10));
			emp.setCountry(rs.getString(11));
		}
		return emp;
	}

	public static boolean updateEmployee(EmployeeDTO emp) throws ClassNotFoundException, SQLException {
		boolean status = false;
		Connection con = getConnection();
		String sql = "update employee5 set " + "firstname=?,lastname=?," + "username=?,email=?,password=?,phone=?,\r\n"
				+ "age=?,country=?,city=?,state=? " + "where id=?";
		// Create PreparedStatements
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, emp.getFirstname());
		pstmt.setString(2, emp.getLastname());
		pstmt.setString(3, emp.getUsername());
		pstmt.setString(4, emp.getEmail());
		pstmt.setString(5, emp.getPassword());
		pstmt.setLong(6, emp.getPhone());
		pstmt.setInt(7, emp.getAge());
		pstmt.setString(8, emp.getCountry());
		pstmt.setString(9, emp.getCity());
		pstmt.setString(10, emp.getState());
		pstmt.setInt(11, emp.getId());
		
		int i = pstmt.executeUpdate();
		
		if (i > 0) {
			status = true;
		}

		return status;
	}
}
