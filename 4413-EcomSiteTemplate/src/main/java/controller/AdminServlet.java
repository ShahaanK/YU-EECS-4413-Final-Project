package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import dao.DAOImpl;
import model.Payment;
import model.ProductOrder;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DAO dao;

    @Override
    public void init() throws ServletException {
        super.init();
        dao = new DAOImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the list of payments from the database
        List<Payment> payments = dao.getAllPayments();

        // Retrieve the list of orders from the database
        List<ProductOrder> orders = dao.getAllOrders();

        
        // Set the payments and orders lists as request attributes
        request.setAttribute("payments", payments);
        request.setAttribute("orders", orders);

        // Forward to the admin page to display the payments and orders
        request.getRequestDispatcher("/jsp/admin.jsp").forward(request, response);
    }
}
