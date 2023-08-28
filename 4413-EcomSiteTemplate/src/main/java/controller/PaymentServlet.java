package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import dao.DAOImpl;
import model.Admin;
import model.Cart;
import model.Customer;
import model.Item;
import model.Payment;
import model.ProductOrder;

@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DAO dao;

    @Override
    public void init() throws ServletException {
        super.init();
        dao = new DAOImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cardNumber = request.getParameter("cardNumber");
        String expirationDate = request.getParameter("expirationDate");
        String cvv = request.getParameter("cvv");
        HttpSession session = request.getSession();
        Object userObj = session.getAttribute("user");


        boolean isValidCard = validateCardInformation(cardNumber, expirationDate, cvv);
        if (userObj == null) {
            // Redirect the user to the login page
            response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
            return; 
        } else {
            if (userObj instanceof Customer) {
                Customer customer = (Customer) userObj;
                // Handle customer payment
                if (isValidCard) {
                    int lastDigit = Character.getNumericValue(cardNumber.charAt(cardNumber.length() - 1));
                    boolean paymentSuccess = (lastDigit % 2 == 1);

                    if (paymentSuccess) {
                        int paymentID = generateRandomPaymentID();
                        int orderID = generateRandomProductID(); // You need to implement this method

                        Payment payment = new Payment(paymentID, cardNumber, expirationDate, cvv, orderID);
                        dao.insertPayment(payment);
                        
                        Cart cart = getCart(request);
                        double totalCartPrice = cart.calculateTotalPrice();

                        // Create an instance of ProductOrder and populate its attributes
                        ProductOrder order = new ProductOrder();
                        order.setId(orderID);
                        order.setCustomerID(customer.getId());
                        order.setDateOfPurchase(getCurrentDate());
                        order.setTotalPrice(totalCartPrice);

                        dao.insertOrder(order);

                        String paymentMessage = "Order Successfully Completed.";
                        request.setAttribute("paymentMessage", paymentMessage);
                        request.setAttribute("orderID", orderID);
                        request.setAttribute("paymentID", paymentID);
                        request.setAttribute("cardNumber", cardNumber);
                        request.setAttribute("expirationDate", expirationDate);
                        request.setAttribute("cvv", cvv);
                        
                        emptyCart(request);
                    } else {
                        String errorMessage = "Credit Card Authorization Failed.";
                        request.setAttribute("errorMessage", errorMessage);
                    }

                    request.getRequestDispatcher("/jsp/paymentResult.jsp").forward(request, response);
                } else {
                    String errorMessage = "Invalid Card Information.";
                    request.setAttribute("errorMessage", errorMessage);
                    request.getRequestDispatcher("/jsp/paymentResult.jsp").forward(request, response);
                }
            } else if (userObj instanceof Admin) {
                // Redirect the admin to the admin page
                response.sendRedirect(request.getContextPath() + "/jsp/admin.jsp");
                return;
            }
        }


        
    }

    private boolean validateCardInformation(String cardNumber, String expirationDate, String cvv) {
        // Implement card information validation logic here
        // Example validation:
        boolean isCardValid = true;

        if (!cardNumber.matches("\\d{16}")) {
            isCardValid = false;
        }

        if (!expirationDate.matches("\\d{2}/\\d{2}")) {
            isCardValid = false;
        }

        if (!cvv.matches("\\d{3}")) {
            isCardValid = false;
        }

        return isCardValid;
    }

    private int generateRandomProductID() {
        Random random = new Random();
        return random.nextInt(10000); // Adjust the range as needed
    }
    
    private int generateRandomPaymentID() {
        Random random = new Random();
        return random.nextInt(1000000); // Adjust the range as needed
    }
    
    
    private String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        return dateFormat.format(currentDate);
    }
    
    private int extractCustomerIDFromSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("user");
        return customer.getId(); 
    }

    private Cart getCart(HttpServletRequest request) {
        return (Cart) request.getSession().getAttribute("cart");
    }
    
    private void emptyCart(HttpServletRequest request) {
        // Remove the cart object from the session
        request.getSession().removeAttribute("cart");
    }

 }

