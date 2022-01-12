package org.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.assignment.dao.UserDAO;

@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		int status = 0;
		long mobileNumber = Long.parseLong(request.getParameter("mobileNumber"));
		
		status = UserDAO.deleteUser(mobileNumber);
		
		if (status > 0) {
			out.println("<h3>User deleted !!!</h3>");
		} else {
			out.println("<h3>failed to delete !!!</h3>");
		}
		
		response.sendRedirect("GetUsers");
	}
}
