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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve payment information and order details using DAO
        List<Payment> payments = dao.getAllPayments(); 
        List<ProductOrder> orders = dao.getAllOrders(); 

        // Set attributes in request
        request.setAttribute("payments", payments);
        request.setAttribute("orders", orders);

        // Forward to admin.jsp
        request.getRequestDispatcher("/jsp/admin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle any post request if needed
    }
}
