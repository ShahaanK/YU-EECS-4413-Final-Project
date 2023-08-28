package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import dao.DAOImpl;
import model.Payment;
import model.ProductOrder;

@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cardNumber = request.getParameter("cardNumber");
        String expirationDate = request.getParameter("expirationDate");
        String cvv = request.getParameter("cvv");

        // Generate a random 6-digit order ID
        Random random = new Random();
        int orderID = random.nextInt(900000) + 100000;

        Payment payment = new Payment();
        payment.setCardNum(cardNumber);
        payment.setExpir(expirationDate);
        payment.setCvv(cvv);

        // Get the order ID from the session (assuming you have stored it during the order process)
        HttpSession session = request.getSession();
        int customerID = (int) session.getAttribute("customerID"); // Replace with the actual attribute name
        String dateOfPurchase = ""; // Replace with the actual date of purchase

        // Save the payment using DAO
        DAO dao = new DAOImpl(); // Create an instance of your DAO implementation
        try {
            // Save the payment and get the payment ID
            int paymentID = dao.savePayment(payment, orderID);

            // Create ProductOrder object with necessary details
            ProductOrder order = new ProductOrder();
            order.setId(orderID); // Set the generated order ID
            order.setCustomerID(customerID); // Set the actual customer ID
            order.setDateOfPurchase(dateOfPurchase); // Set the actual date of purchase
            order.setTotalPrice(0.0); // Replace with the actual total price

            // Save the order and get the generated order ID
            dao.saveProductOrder(order);

            // Set attributes for payment result JSP
            request.setAttribute("paymentMessage", "Order Successfully Completed.");
            request.setAttribute("orderID", orderID);
            request.setAttribute("paymentID", paymentID);
            request.setAttribute("cardNumber", cardNumber); // You can mask the card number if needed
            request.setAttribute("expirationDate", expirationDate);
            request.setAttribute("cvv", cvv);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception
            request.setAttribute("paymentError", "An error occurred while processing the payment.");
            request.getRequestDispatcher("/jsp/payment.jsp").forward(request, response);
            return;
        }

        // Validate cardNumber (16 digits)
        if (!cardNumber.matches("\\d{16}")) {
            request.setAttribute("paymentError", "Invalid card number. Card number must be 16 digits.");
            request.getRequestDispatcher("/jsp/payment.jsp").forward(request, response);
            return;
        }

        // Validate expirationDate (mm/yy format)
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yy");
        try {
            Date expDate = dateFormat.parse(expirationDate);
            if (expDate.before(new Date())) {
                request.setAttribute("paymentError", "Invalid expiration date. Expiration date must be in the future.");
                request.getRequestDispatcher("/jsp/payment.jsp").forward(request, response);
                return;
            }
        } catch (ParseException e) {
            request.setAttribute("paymentError", "Invalid expiration date format. Use mm/yy format.");
            request.getRequestDispatcher("/jsp/payment.jsp").forward(request, response);
            return;
        }

        // Validate cvv (3 digits)
        if (!cvv.matches("\\d{3}")) {
            request.setAttribute("paymentError", "Invalid CVV. CVV must be 3 digits.");
            request.getRequestDispatcher("/jsp/payment.jsp").forward(request, response);
            return;
        }

        int lastDigit = Integer.parseInt(cardNumber.substring(cardNumber.length() - 1));
        if (lastDigit % 2 == 0) {
            request.setAttribute("paymentMessage", "Payment declined.");
            request.getRequestDispatcher("/jsp/paymentResult.jsp").forward(request, response);
            return;
        } else {

            request.setAttribute("paymentMessage", "Payment successful!");
            request.getRequestDispatcher("/jsp/paymentResult.jsp").forward(request, response);
            return;

        }

    }
}
