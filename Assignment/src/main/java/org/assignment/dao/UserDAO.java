package org.assignment.dao;

import org.assignment.user.*;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class UserDAO {

	private static String dbUser = "root";
	private static String dbPassword = "root";
	private static String dbName = "userdb";
	private static String dbAddress = "jdbc:mysql://localhost:3306/" + dbName + "?createDatabaseIfNotExist=true";
	private static String dbTableName = "testing";
	
	// Connection with Database
	public static Connection getConnection() {

		Connection con = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, dbUser, dbPassword);
			con = DriverManager.getConnection(dbAddress, dbUser, dbPassword);

		} catch (Exception e) {
			System.out.print(e);
			e.printStackTrace();
		}
		return con;
	}
	
	// Create table in database doesn't exist already
	public static void createTableIfNotExist() {
		
		Connection con = UserDAO.getConnection();
		
	    try {
			String createTable = "CREATE TABLE IF NOT EXISTS " + dbTableName
			        + "(firstName VARCHAR(30),"
			        + " lastName VARCHAR(30),"
			        + " dateOfBirth date,"
			        + " city VARCHAR(30),"
			        + " mobileNumber VARCHAR(30) NOT NULL, PRIMARY KEY (mobileNumber) )";

			PreparedStatement ps = con.prepareStatement(createTable);
			ResultSet rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Get all the users
	public static List<User> getAllUsers() {

		List<User> usersList = new LinkedList<User>();

		Connection con = UserDAO.getConnection();
		UserDAO.createTableIfNotExist();

		try {
			PreparedStatement ps = con.prepareStatement("select * from " + dbTableName);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				User user = new User();

				user.setFirstName(rs.getString(1));
				user.setLastName(rs.getString(2));
				user.setCity(rs.getString(4));
				user.setMobileNumber(Long.parseLong(rs.getString(5)));

				java.sql.Date sqlDate = rs.getDate(3);
				user.setDateOfBirth(sqlDate);

				usersList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

//		con.close();
		return usersList;
	}

	// Create a new user
	public static int createNewUser(User user) {

		int status = 0;

		Connection con = UserDAO.getConnection();
		UserDAO.createTableIfNotExist();

		try {
			PreparedStatement ps = con.prepareStatement("insert into " + dbTableName + " values(?,?,?,?,?)");
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, String.valueOf(user.getDateOfBirth()));
			ps.setString(4, user.getCity());
			ps.setString(5, String.valueOf(user.getMobileNumber()));

			status = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

//		con.close();
		return status;
	}

	// Delete existing user
	public static int deleteUser(long mobileNumber) {

		int status = 0;

		Connection con = UserDAO.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement("delete from " + dbTableName +" where mobileNumber=?");
			ps.setString(1, String.valueOf(mobileNumber));

			status = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		con.close();
		return status;
	}

	// Update details of existing user
	public static int updateUser(User user) {

		int status = 0;

		Connection con = UserDAO.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(
					"update " + dbTableName + " set firstName=?, lastName=?, dateOfBirth=?, City=? where mobileNumber=?");

			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setDate(3, user.getDateOfBirth());
			ps.setString(4, user.getCity());
			ps.setString(5, String.valueOf(user.getMobileNumber()));

			status = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		con.close();
		return status;
	}
}
