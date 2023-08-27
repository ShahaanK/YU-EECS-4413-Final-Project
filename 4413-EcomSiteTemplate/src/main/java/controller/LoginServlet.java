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

import dao.DAOImpl;
import model.Admin;
import model.Customer;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "login":
                    String username = request.getParameter("username");
                    String pwd = request.getParameter("password");

                    // Here you would implement your login validation logic
                    // For demonstration purposes, I'll assume a simple check
                    // Replace this with your actual authentication logic

                    if ("validUsername".equals(username) && "validPassword".equals(pwd)) {
                        // Valid login, redirect to a success page or dashboard
                        response.sendRedirect("success.jsp");
                    } else {
                        // Invalid login, redirect back to the login page with an error message
                        request.setAttribute("errorMessage", "Invalid username or password");
                        request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
                    }
                    break;

                case "register":
                    String userType = request.getParameter("userType");
                    String firstName = request.getParameter("firstName");
                    String lastName = request.getParameter("lastName");
                    String email = request.getParameter("email");
                    String phoneNumber = request.getParameter("phoneNumber");
                    String password = request.getParameter("password");

                    DAOImpl userDAO = new DAOImpl();
                    boolean registrationSuccess = false;

                    if ("customer".equals(userType)) {
                        Customer newCustomer = new Customer();
                        newCustomer.setFirstName(firstName);
                        newCustomer.setLastName(lastName);
                        newCustomer.setEmail(email);
                        newCustomer.setPhone(phoneNumber);
                        newCustomer.setPassword(password);

                        registrationSuccess = userDAO.insertCustomer(newCustomer);
                    } else if ("admin".equals(userType)) {
                        Admin newAdmin = new Admin();
                        newAdmin.setFirstName(firstName);
                        newAdmin.setLastName(lastName);
                        newAdmin.setEmail(email);
                        newAdmin.setPassword(password);

                        registrationSuccess = userDAO.insertAdmin(newAdmin);
                    }

                    if (registrationSuccess) {
                        response.sendRedirect("registrationSuccess.jsp");
                    } else {
                        request.setAttribute("errorMessage", "Failed to register user");
                        request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
                    }
                    break;

                default:
                    break;
            }
        }
    }
}
