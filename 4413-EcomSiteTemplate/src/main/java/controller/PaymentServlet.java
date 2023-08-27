package controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import dao.DAOImpl;
import model.Payment;

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

        boolean isValidCard = validateCardInformation(cardNumber, expirationDate, cvv);

        if (isValidCard) {
            int lastDigit = Character.getNumericValue(cardNumber.charAt(cardNumber.length() - 1));
            boolean paymentSuccess = (lastDigit % 2 == 1);

            if (paymentSuccess) {
                int paymentID = generateRandomID();; // Generate payment ID
                int orderID = extractOrderIDFromSession(request); // Obtain order ID from session or application logic

                Payment payment = new Payment(paymentID, cardNumber, expirationDate, cvv, orderID);
                dao.insertPayment(payment);

                String paymentMessage = "Order Successfully Completed.";
                request.setAttribute("paymentMessage", paymentMessage);
                request.setAttribute("orderID", orderID); // Set orderID attribute
                request.setAttribute("paymentID", paymentID); // Set paymentID attribute
                request.setAttribute("cardNumber", cardNumber);
                request.setAttribute("expirationDate", expirationDate);
                request.setAttribute("cvv", cvv);
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

    private int generateRandomID() {
        Random random = new Random();
        return random.nextInt(1000000); // Adjust the range as needed
    }
    private int extractOrderIDFromSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        int orderID = 1; // Default value if order ID is not found

        // Replace "yourOrderIDAttributeName" with the actual attribute name used to store order ID in the session
        Object orderIDObj = session.getAttribute("yourOrderIDAttributeName");

        if (orderIDObj != null && orderIDObj instanceof Integer) {
            orderID = (Integer) orderIDObj;
        }

        return orderID;
    }

 }

