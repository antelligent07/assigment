Title: Assignment

Description:
  A simple application to manage user in a system.
  One can create, edit and delete the users from the system.

Technology used:
  Frontend: HTML
  Backend: Java, Java Servlet
  Database: MySQL
  
Steps to run the application:
  1. Clone the repository on desired location.
  2. Open any IDE like Eclipse, Intellij Idea etc.
  3. Import the project into IDE as dynamic web project.
  4. This application will require MySQL database, MySQL JDBC Connector and Apache Tomcat Server.
  5. In this repository I provided MySQL JDBC Connector 8.0.27 and Apache Tomcat Server 9.0.41 in "RequiredFiles" directory.
  6. Add Apache Tomcat Server from "RequiredFiles" directory to the IDE in which you imported the project.
  7. Import MySQL JDBC Connector 8.0.27 for the project from "RequiredFiles" directory
  8. If on your system database username and database password of MySQL database is other than "root" and "root" then please update the database username and database password in file "Assignment/src/main/java/org/assignment/dao/UserDAO.java".
  9.  Refresh project, clean and build it.
  10.  To run the project double click on project from IDE -> click on "Run as" -> click on "Run on Server".
  11.  Hit the url in browser http://localhost:8080/Assignment/
  12.  Access the application.
