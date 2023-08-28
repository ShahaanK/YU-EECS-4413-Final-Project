package controller;

import java.io.IOException;
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        String url = "/jsp/cart.jsp"; // Replace with your JSP file path

        if (action != null) {
            switch (action) {
                case "add":
                    String productID = request.getParameter("productID");
                    String productName = request.getParameter("productName");
                    String colour = request.getParameter("colour");
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    double price = Double.parseDouble(request.getParameter("price"));
                    String image = request.getParameter("image");
                    String category = request.getParameter("category");
                    String brand = request.getParameter("brand");

                    Cart cart = getOrCreateCart(request);
                    cart.add(productID, productName, colour, quantity, price, image, category, brand);
                    System.out.println("Added to cart: " + productName);
                    break;
                    
                case "update":
                    String productIDToUpdate = request.getParameter("productIDToUpdate");
                    String newQtyStr = request.getParameter("quantity_" + productIDToUpdate);

                    if (newQtyStr != null && !newQtyStr.isEmpty()) {
                        int newQuantity = Integer.parseInt(newQtyStr);
                        Cart cartToUpdate = getCart(request);
                        if (cartToUpdate != null) {
                            cartToUpdate.update(productIDToUpdate, newQuantity);
                        }
                    }
                    break;

                case "remove":
                    String productIDToRemove = request.getParameter("productIDToRemove");
                    Cart cartToRemoveFrom = getCart(request);
                    if (cartToRemoveFrom != null) {
                        cartToRemoveFrom.remove(productIDToRemove);
                    }
                    break;

            }
        }
        request.getSession().setAttribute("cart", getOrCreateCart(request));
        request.getRequestDispatcher(url).forward(request, response);

    }
/*  getOrCreateCart(HttpServletRequest request): This method checks if a Cart object exists in the session. 
 * If it does, it returns the existing Cart object. 
 * If it doesn't exist, it creates a new Cart object, sets it in the session, and then returns it. 
 * This method ensures that you always have a valid Cart object to work with.
 */

    private Cart getOrCreateCart(HttpServletRequest request) {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        return cart;
    }
    /*getCart(HttpServletRequest request): This method simply retrieves the Cart object from the session. 
     * It doesn't create a new Cart object if it doesn't exist. 
     * This is useful when you want to access the existing Cart object without modifying it.
     */
    private Cart getCart(HttpServletRequest request) {
        return (Cart) request.getSession().getAttribute("cart");
    }
}
