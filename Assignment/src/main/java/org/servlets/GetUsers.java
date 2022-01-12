package org.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.assignment.dao.UserDAO;
import org.assignment.user.User;

@WebServlet("/GetUsers")
public class GetUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetUsers() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<a href='index.html'>Add New User</a>");
		out.println("<h1>Users List</h1>");

		List<User> usersList;
		usersList = UserDAO.getAllUsers();

		out.print("<table border='1' width='100%'");
		out.print("<tr><th>First Name</th><th>Last Name</th><th>DOB</th><th>City</th><th>Mobile Number</th><th>Edit</th><th>Delete</th></tr>");
		for (User user : usersList) {
//			System.out.println(user);
			out.print("<tr><td>" + user.getFirstName() + "</td><td>" + user.getLastName() + "</td><td>"
					+ user.getDateOfBirth() + "</td><td>" + user.getCity() + "</td><td>" + user.getMobileNumber()
					+ "</td><td><a href='UpdateUserPage?mobileNumber=" + user.getMobileNumber()
					+ "'>edit</a></td><td><a href='DeleteUser?mobileNumber=" + user.getMobileNumber()
					+ "'>delete</a></td></tr>");
		}

		out.print("</table>");

		out.close();

	}
}
