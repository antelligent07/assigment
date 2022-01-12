package org.assignment.dao;

import org.assignment.user.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserDAO {

	public static Connection getConnection() {

		Connection con = null;

		try {
			
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","raza","root");
			
		} catch (Exception e) {
			System.out.print(e);
			e.printStackTrace();
		}
		return con;
	}
	
	public static List<User> getAllUsers() {
		
		List<User> usersList = new LinkedList<User>();
		
		Connection con = UserDAO.getConnection();
		System.out.println(con);
		
		return usersList;
	}
}
