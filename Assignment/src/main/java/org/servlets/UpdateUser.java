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

@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateUser() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        User user =  new User(request.getParameter("firstName"), request.getParameter("lastName"), String.valueOf(request.getParameter("dateOfBirth")),
        		request.getParameter("city"), request.getParameter("mobileNumber"));
                
        int status = 0;
		status = UserDAO.updateUser(user);  
        if(status>0){  
            response.sendRedirect("GetUsers");  
        }else{  
            out.println("failed to update record");  
        }  
          
        out.close(); 
	}
}
