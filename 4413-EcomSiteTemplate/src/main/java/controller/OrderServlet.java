package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.Customer;
import model.ProductOrder;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public OrderServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");

        if (customer == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        Cart cart = (Cart) session.getAttribute("cart");

        if (cart.isEmpty()) {
            response.sendRedirect("emptyCart.jsp");
            return;
        }

        double totalPrice = cart.calculateTotalPrice();

        ProductOrder order = new ProductOrder();
        order.setCustomerID(customer.getId());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentDate = new Date();
        String dateOfPurchase = dateFormat.format(currentDate);

        order.setDateOfPurchase(dateOfPurchase);
        order.setTotalPrice(totalPrice);

        // saving to a database
        // use a DAO handle database operations

        cart.clear();

        request.setAttribute("order", order);
        request.getRequestDispatcher("finalCheckout.jsp").forward(request, response);
    }
}
