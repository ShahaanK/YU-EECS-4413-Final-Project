package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Payment;
import model.ProductOrder;

import java.io.IOException;
import java.util.List;
import dao.DAOImpl;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    private DAOImpl dao = new DAOImpl(); // Instantiate your DAO implementation

   
}
