package org.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.assignment.dao.UserDAO;
import org.assignment.user.User;

@WebServlet("/CreateUser")
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateUser() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int status = 0;
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String dateOfBirth = request.getParameter("dateOfBirth");
		String city = request.getParameter("city");
		String mobileNumber = request.getParameter("mobileNumber");
		
		
		try {
			status = UserDAO.createNewUser(new User(firstName, lastName, dateOfBirth, city, mobileNumber));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (status > 0) {
			out.println("<h3>User added !!!</h3>");
			request.getRequestDispatcher("index.html").include(request, response);
		}
		else {
			out.println("Failed to add user");
		}
		out.close();
	}
}
