//package controller;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class LoginServlet
// */
//@WebServlet("/LoginServlet")
//public class LoginServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//	public LoginServlet() {
//        super();
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        // Determine the type of login (customer or admin)
//        String userType = request.getParameter("userType");
//
//        if (userType != null) {
//            switch (userType) {
//                case "customer":
//                    response.sendRedirect("login.jsp");
//                    break;
//                case "admin":
//                    response.sendRedirect("admin.jsp");//fix later for to have the customer and admin in the same login-jsp page
//                    break;
//                default:
//                    break;
//            }
//        }
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        doGet(request, response);
//    }
//
//}

package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String JDBC_URL = "jdbc:sqlite:/Users/mumtazkermali/Downloads/4413DB_1.db";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String userType = request.getParameter("userType");

        if (username != null && password != null && userType != null) {
            try {
                Connection connection = DriverManager.getConnection(JDBC_URL);

                String query;
                if ("customer".equals(userType)) {
                    query = "SELECT id, firstName, lastName FROM Customer WHERE email = ? AND password = ?";
                } else if ("admin".equals(userType)) {
                    query = "SELECT adminID, firstName, lastName FROM Admin WHERE email = ? AND password = ?";
                } else {
                    // Handle other user types if needed
                	System.out.println("user doesnt exist");
                    return;
                }

                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, username);
                statement.setString(2, password);

                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    // User exists, set up session and redirect
                    HttpSession session = request.getSession();
                    session.setAttribute("userID", resultSet.getInt(1));
                    session.setAttribute("userFirstName", resultSet.getString(2));
                    session.setAttribute("userLastName", resultSet.getString(3));

                    if ("customer".equals(userType)) {
                        response.sendRedirect("customer_home.jsp");
                    } else if ("admin".equals(userType)) {
                        response.sendRedirect("admin_home.jsp");
                    }
                } else {
                    // User doesn't exist, redirect to an error page or show a message
                    response.sendRedirect("login.jsp?error=invalid");
                }

                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle database error
                response.sendRedirect("login.jsp?error=db");
            }
        } else {
            // Invalid input, handle accordingly
            response.sendRedirect("login.jsp?error=invalid-input");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle GET requests
        doPost(request, response);
    }
}
