package org.assignment.dao;

import org.assignment.user.*;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class UserDAO {

	public static Connection getConnection() {

		Connection con = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root", "root");

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

		try {
			PreparedStatement ps = con.prepareStatement("select * from users");
			ResultSet rs = ps.executeQuery();
			
			User user = new User();
			
			while(rs.next()) {

				user.setFirstName(rs.getString(1));
				user.setLastName(rs.getString(2));
				user.setCity(rs.getString(4));
				user.setMobileNumber(Long.parseLong(rs.getString(5)));

				java.sql.Date sqlDate = rs.getDate(3);
				java.util.Date date = sqlDate;
				user.setDateOfBirth(date);
				
//				String mydate = "1999-01-07";
//				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
//				java.util.Date userdate = null;
//				try {
//					userdate = dateFormat.parse(mydate);
//				} catch (ParseException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//				System.out.println(dateFormat.format(userdate));
//				System.out.println(user);
				usersList.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return usersList;
	}
}
