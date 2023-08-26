package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cart;
import model.Item;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            if (action.equals("add")) {
                // Get item details from request and add it to the cart
                String productID = request.getParameter("productID");
                String productName = request.getParameter("productName");
                String colour = request.getParameter("colour");
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                double price = Double.parseDouble(request.getParameter("price"));
                String image = request.getParameter("image");
                String category = request.getParameter("category");
                String brand = request.getParameter("brand");

                Cart cart = (Cart) request.getSession().getAttribute("cart");
                if (cart == null) {
                    cart = new Cart();
                    request.getSession().setAttribute("cart", cart);
                }

                cart.add(productID, productName, colour, quantity, price, image, category, brand);
            } else if (action.equals("update")) {
                // Update the quantity of an item in the cart
                String productID = request.getParameter("productID");
                int newQuantity = Integer.parseInt(request.getParameter("newQuantity"));

                Cart cart = (Cart) request.getSession().getAttribute("cart");
                if (cart != null) {
                    cart.update(productID, newQuantity);
                }
            } else if (action.equals("remove")) {
                // Remove an item from the cart
                String productID = request.getParameter("productID");

                Cart cart = (Cart) request.getSession().getAttribute("cart");
                if (cart != null) {
                    cart.remove(productID);
                }
            }
        }

        // Forward to the cart JSP page to display the cart
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }
}
