package controller;

import model.Customer;

// Import required packages

public class AccountCreationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        // Create a Customer object
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setPhone(phone);
        customer.setPassword(password);

        // Insert the customer into the database using JDBC
        try {
            // Establish JDBC connection
            Connection connection = DriverManager.getConnection("your-jdbc-url-here");

            // Prepare and execute SQL INSERT query
            String insertQuery = "INSERT INTO Customer (firstName, lastName, email, phone, password) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, customer.getEmail());
            preparedStatement.setString(4, customer.getPhone());
            preparedStatement.setString(5, customer.getPassword());

            // Execute the query
            preparedStatement.executeUpdate();

            // Close resources
            preparedStatement.close();
            connection.close();

            // Redirect or show success message
            response.sendRedirect("login.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            // Handle database error and show error message
            response.sendRedirect("createaccount.jsp?error=db");
        }
    }
}
