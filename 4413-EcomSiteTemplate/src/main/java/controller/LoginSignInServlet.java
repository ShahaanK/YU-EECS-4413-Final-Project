package controller;

import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Address;
import model.Admin;
import model.Customer;
import dao.DAO;
import dao.DAOImpl;

@WebServlet("/LoginSignInServlet")
public class LoginSignInServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            if (action.equals("register")) {
                handleRegistration(request, response);
            } else if (action.equals("login")) {
                handleLogin(request, response);
            }
        }
    }

    private void handleRegistration(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accountType = request.getParameter("accountType");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        DAO dao = new DAOImpl();

        if (accountType.equals("customer")) {
            String street = request.getParameter("street");
            String province = request.getParameter("province");
            String country = request.getParameter("country");
            String postalCode = request.getParameter("postalCode");
            String phone = request.getParameter("phoneNumber");

            int generatedID = generateCustomerID(); // Generate a random ID

            Address address = new Address();
            address.setId(generatedID); // Set the same generated ID for address
            address.setStreet(street);
            address.setProvince(province);
            address.setCountry(country);
            address.setPostalCode(postalCode);
            address.setPhone(phone);

            Customer customer = new Customer();
            customer.setId(generatedID); // Set the same generated ID for customer
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setEmail(email);
            customer.setPassword(password);
            customer.setAddressID(address.getId()); // Set the address ID

            dao.registerCustomer(customer);
      
            // Set registration details as request attributes
            request.setAttribute("accountType", "Customer");
            request.setAttribute("registeredEmail", email);
            
        } else if (accountType.equals("admin")) {
            int adminID = generateAdminID(); // Generate a random 3-digit admin ID
            
            Admin admin = new Admin();
            admin.setAdminID(adminID); // Set the generated admin ID
            admin.setFirstName(firstName);
            admin.setLastName(lastName);
            admin.setEmail(email);
            admin.setPassword(password);

            dao.registerAdmin(admin);
            request.setAttribute("accountType", "Admin");
            request.setAttribute("registeredEmail", email);
        }

        request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
    }

    private void handleLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Implement login logic here
        // You can retrieve login credentials from request parameters
        // Query the database to check if the credentials are valid
        // If valid, redirect to the appropriate page
        // If not valid, show an error message or redirect to a login error page
    }

    // Method to generate a random 3-digit admin ID
    private int generateAdminID() {
        Random random = new Random();
        return random.nextInt(900) + 100;
    }

    // Method to generate a random 4-digit customer ID
    private int generateCustomerID() {
        Random random = new Random();
        return random.nextInt(9000) + 1000;
    }
}
