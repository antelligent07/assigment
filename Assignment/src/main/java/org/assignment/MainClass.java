package org.assignment;

import org.assignment.dao.UserDAO;

public class MainClass {

	public static void main(String[] args) {
		System.out.println("hello");
		UserDAO.getAllUsers();
	}

}
