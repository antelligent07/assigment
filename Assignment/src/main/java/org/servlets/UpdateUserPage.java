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

@WebServlet("/UpdateUserPage")
public class UpdateUserPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateUserPage() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Update User</h1>");

		Long mobileNumber = Long.parseLong(request.getParameter("mobileNumber"));

		List<User> users;
		User record = null;
		users = UserDAO.getAllUsers();

		for (User user : users) {
			if (user.getMobileNumber() == mobileNumber)
				record = user;
		}

		out.print("<form action='UpdateUser' method='post'>");
		out.print("<table>");

		out.print("<tr><td>First Name:</td><td><input type='text' name='firstName' value='" + record.getFirstName()
				+ "'/></td></tr>");
		out.print("<tr><td>Last Name:</td><td><input type='text' name='lastName' value='" + record.getLastName()
				+ "'/></td></tr>");
		out.print("<tr><td>Date of Birth:</td><td><input type='text' name='dateOfBirth' value='" + record.getDateOfBirth()
				+ "'/></td></tr>");
		out.print("<tr><td>City:</td><td><input type='text' name='city' value='" + record.getCity() + "'>");
		out.print("<tr><td></td><td><input type='hidden' name='mobileNumber' value='"
				+ record.getMobileNumber() + "'/></td></tr>");
		out.print("</td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Update & Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");

		out.close();

	}
}
