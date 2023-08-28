package dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.ProductOrderItem;
import model.Item;
import model.Payment;
import model.ProductOrder;
import model.Customer;
import model.Admin;

public class DAOImpl implements DAO {

	//------------Establishing Connection------------------------
	static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

	// complete this method
	private Connection getConnection() throws SQLException {
		String shahaan = "C:\\Users\\shaha\\OneDrive\\Desktop\\4413 - E-Comm\\Project\\4413DB.db";
		String tracy = "//Users//miaonya//Desktop//4413DB.db";
		String mediya = "//put your path here";
		return DriverManager.getConnection("jdbc:sqlite:" + tracy);//replace the name with yours's

	}

	 private void closeConnection(Connection connection) {
	        if (connection == null)
	            return;
	        try {
	            connection.close();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
	//---------------------------------------------

	@Override
	public List<Item> findAllItems() {
        List<Item> result = new ArrayList<>();

        String sql = "select * from Item";

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Item item = new Item();
                item.setProductID(resultSet.getString("productID"));
                item.setProductName(resultSet.getString("productName"));
                item.setColour(resultSet.getString("colour"));
                item.setCategory(resultSet.getString("category"));
                item.setBrand(resultSet.getString("brand"));
                item.setQuantity(resultSet.getInt("quantity"));
                item.setPrice(resultSet.getDouble("price"));
                item.setImage(resultSet.getString("image"));

                result.add(item);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return result;
    }

	@Override
	public List<Item> findAllTops() {
		// TODO Auto-generated method stub
		List<Item> result = new ArrayList<Item>();

		// join 3 tables to get needed info
		String sql = "SELECT * FROM Item WHERE category = 'Shirts'";

		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				
				ProductOrderItem prod = new ProductOrderItem();
				Item item = new Item();
				
				prod.setItemID(resultSet.getString("productID"));
				
				item.setProductID(resultSet.getString("productID"));
				item.setProductName(resultSet.getString("productName"));
				item.setColour(resultSet.getString("colour"));
				item.setCategory(resultSet.getString("category"));
				item.setBrand(resultSet.getString("category"));
				item.setQuantity(resultSet.getInt("category"));
				item.setPrice(resultSet.getDouble("price"));
				item.setImage(resultSet.getString("image"));
				
				
				result.add(item);
				
				
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return result;
	}

	@Override
	public List<Item> findAllBottoms() {
		// TODO Auto-generated method stub
		List<Item> result = new ArrayList<Item>();

		// join 3 tables to get needed info
		String sql = "SELECT * FROM Item WHERE category = 'Pants'";

		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				
				ProductOrderItem prod = new ProductOrderItem();
				Item item = new Item();
				
				prod.setItemID(resultSet.getString("productID"));
				
				item.setProductID(resultSet.getString("productID"));
				item.setProductName(resultSet.getString("productName"));
				item.setColour(resultSet.getString("colour"));
				item.setCategory(resultSet.getString("category"));
				item.setBrand(resultSet.getString("category"));
				item.setQuantity(resultSet.getInt("category"));
				item.setPrice(resultSet.getDouble("price"));
				item.setImage(resultSet.getString("image"));
				
				
				result.add(item);
				
				
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return result;
	}

	@Override
	public List<Item> findByBrand(String name) { //S
		
		List<Item> result = new ArrayList<Item>();

		String sql = "SELECT * FROM Item WHERE brand = ?";
		
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				
				ProductOrderItem prod = new ProductOrderItem();
				Item item = new Item();
				
				prod.setItemID(resultSet.getString("productID"));
				
				item.setProductID(resultSet.getString("productID"));
				item.setProductName(resultSet.getString("productName"));
				item.setColour(resultSet.getString("colour"));
				item.setCategory(resultSet.getString("category"));
				item.setBrand(resultSet.getString("category"));
				item.setQuantity(resultSet.getInt("category"));
				item.setPrice(resultSet.getDouble("price"));
				item.setImage(resultSet.getString("image"));
				
				
				result.add(item);
				
				
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return result;
	}

	@Override
	public List<Item> searchKeyword(String keyWord) {
	    List<Item> result = new ArrayList<>();

	    // SQL query to search for the keyword in relevant columns
	    String sql = "SELECT * FROM Item " +
	                 "WHERE productName LIKE ? OR " +
	                 "colour LIKE ? OR " +
	                 "category LIKE ? OR " +
	                 "brand LIKE ?";

	    Connection connection = null;
	    try {
	        connection = getConnection();

	        PreparedStatement statement = connection.prepareStatement(sql);

	        String keywordPattern = "%" + keyWord + "%";
	        statement.setString(1, keywordPattern); // productName
	        statement.setString(2, keywordPattern); // colour
	        statement.setString(3, keywordPattern); // category
	        statement.setString(4, keywordPattern); // brand

	        ResultSet resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            Item item = new Item();
	            item.setProductID(resultSet.getString("productID"));
	            item.setProductName(resultSet.getString("productName"));
	            item.setColour(resultSet.getString("colour"));
	            item.setCategory(resultSet.getString("category"));
	            item.setBrand(resultSet.getString("brand"));
	            item.setQuantity(resultSet.getInt("quantity"));
	            item.setPrice(resultSet.getDouble("price"));
	            item.setImage(resultSet.getString("image"));

	            result.add(item);
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace(); 
	    } finally {
	        closeConnection(connection); 
	    }

	    return result;
	}


	@Override
	public List<Item> getSortHiLo(boolean ascending) {
	    List<Item> result = new ArrayList<>();

	    // SQL query to sort items by price (high to low)
	    String sql = "SELECT * FROM Item ORDER BY price ";

	    Connection connection = null;
	    try {
	        connection = getConnection(); 
	        PreparedStatement statement = connection.prepareStatement(sql);
	        ResultSet resultSet = statement.executeQuery(sql);

	        while (resultSet.next()) {
	            Item item = new Item();
	            item.setProductID(resultSet.getString("productID"));
	            item.setProductName(resultSet.getString("productName"));
	            item.setColour(resultSet.getString("colour"));
	            item.setCategory(resultSet.getString("category"));
	            item.setBrand(resultSet.getString("brand"));
	            item.setQuantity(resultSet.getInt("quantity"));
	            item.setPrice(resultSet.getDouble("price"));
	            item.setImage(resultSet.getString("image"));

	            result.add(item);
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace(); 
	    } finally {
	        closeConnection(connection); 
	    }

	    return result;
	}

	@Override
	public List<Item> getSortLoHi(boolean descending) {
	    List<Item> result = new ArrayList<>();

	    // SQL query to sort items by price in ascending order (low to high)
	    String sql = "SELECT * FROM Item ORDER BY price ";

	    Connection connection = null;
	    try {
	        connection = getConnection(); 
	        PreparedStatement statement = connection.prepareStatement(sql);
	        ResultSet resultSet = statement.executeQuery(sql);

	        while (resultSet.next()) {
	            Item item = new Item();
	            // Populate the Item object with data from the result set
	            item.setProductID(resultSet.getString("productID"));
	            item.setProductName(resultSet.getString("productName"));
	            item.setColour(resultSet.getString("colour"));
	            item.setCategory(resultSet.getString("category"));
	            item.setBrand(resultSet.getString("brand"));
	            item.setQuantity(resultSet.getInt("quantity"));
	            item.setPrice(resultSet.getDouble("price"));
	            item.setImage(resultSet.getString("image"));

	            result.add(item);
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace(); 
	    } finally {
	        closeConnection(connection); 
	    }

	    return result;
	}


	@Override
	public List<Item> getSortAZ(boolean ascending) {
	    List<Item> result = new ArrayList<>();

	    // SQL query to sort items by product name (A to Z)
	    String sql = "SELECT * FROM Item ORDER BY productName";

	    Connection connection = null;
	    try {
	        connection = getConnection(); // Replace with your connection logic
	        PreparedStatement statement = connection.prepareStatement(sql);
	        ResultSet resultSet = statement.executeQuery(sql);

	        while (resultSet.next()) {
	            Item item = new Item();
	            // Populate the Item object with data from the result set
	            item.setProductID(resultSet.getString("productID"));
	            item.setProductName(resultSet.getString("productName"));
	            item.setColour(resultSet.getString("colour"));
	            item.setCategory(resultSet.getString("category"));
	            item.setBrand(resultSet.getString("brand"));
	            item.setQuantity(resultSet.getInt("quantity"));
	            item.setPrice(resultSet.getDouble("price"));
	            item.setImage(resultSet.getString("image"));

	            result.add(item);
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace(); 
	    } finally {
	        closeConnection(connection); 
	    }

	    return result;
	}
	
	@Override
	public List<Item> getSortZA(boolean descending) {
	    List<Item> result = new ArrayList<>();

	    // SQL query to sort items by product name (A to Z)
	    String sql = "SELECT * FROM Item ORDER BY productName " + (descending ? "DESC" : "ASC");

	    Connection connection = null;
	    try {
	        connection = getConnection(); // Replace with your connection logic
	        PreparedStatement statement = connection.prepareStatement(sql);
	        ResultSet resultSet = statement.executeQuery(sql);

	        while (resultSet.next()) {
	            Item item = new Item();
	            // Populate the Item object with data from the result set
	            item.setProductID(resultSet.getString("productID"));
	            item.setProductName(resultSet.getString("productName"));
	            item.setColour(resultSet.getString("colour"));
	            item.setCategory(resultSet.getString("category"));
	            item.setBrand(resultSet.getString("brand"));
	            item.setQuantity(resultSet.getInt("quantity"));
	            item.setPrice(resultSet.getDouble("price"));
	            item.setImage(resultSet.getString("image"));

	            result.add(item);
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace(); 
	    } finally {
	        closeConnection(connection); 
	    }

	    return result;
	}
	@Override
	public List<Item> getImage() {
	    List<Item> result = new ArrayList<>();

	    String sql = "SELECT productID, productName, image FROM Item";// for searching and put the image to the web

	    Connection connection = null;
	    try {
	        connection = getConnection(); // Replace with your connection logic
	        PreparedStatement statement = connection.prepareStatement(sql);
	        ResultSet resultSet = statement.executeQuery(sql);

	        while (resultSet.next()) {
	            Item item = new Item();
	            // Populate the Item object with data from the result set
	            item.setProductID(resultSet.getString("productID"));
	            item.setProductName(resultSet.getString("productName"));
	            item.setColour(resultSet.getString("colour"));
	            item.setCategory(resultSet.getString("category"));
	            item.setBrand(resultSet.getString("brand"));
	            item.setQuantity(resultSet.getInt("quantity"));
	            item.setPrice(resultSet.getDouble("price"));
	            item.setImage(resultSet.getString("image"));

	            result.add(item);
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace(); 
	    } finally {
	        closeConnection(connection); 
	    }

	    return result;
	}
	
	
	@Override
	public List<Item> getRandomItems(int count) {
	    List<Item> result = new ArrayList<>();

	    String sql = "SELECT * FROM Item ORDER BY RANDOM() LIMIT ?";

	    Connection connection = null;
	    try {
	        connection = getConnection();
	        PreparedStatement statement = connection.prepareStatement(sql);
	        statement.setInt(1, count);
	        ResultSet resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            Item item = new Item();
	            item.setProductID(resultSet.getString("productID"));
	            item.setProductName(resultSet.getString("productName"));
	            item.setColour(resultSet.getString("colour"));
	            item.setCategory(resultSet.getString("category"));
	            item.setBrand(resultSet.getString("brand"));
	            item.setQuantity(resultSet.getInt("quantity"));
	            item.setPrice(resultSet.getDouble("price"));
	            item.setImage(resultSet.getString("image"));

	            result.add(item);
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } finally {
	        closeConnection(connection);
	    }

	    return result;
	}
	
	@Override
	public void registerCustomer(Customer customer) {
	    Connection connection = null;
	    try {
	        connection = getConnection();

	        String sql = "INSERT INTO Customer (id, firstName, lastName, email, phone, password, addressID) VALUES (?, ?, ?, ?, ?, ?, ?)";

	        PreparedStatement statement = connection.prepareStatement(sql);
	        statement.setInt(1, generateCustomerID()); // Generate and set the customer ID
	        statement.setString(2, customer.getFirstName());
	        statement.setString(3, customer.getLastName());
	        statement.setString(4, customer.getEmail());
	        statement.setString(5, customer.getPhone());
	        statement.setString(6, customer.getPassword());
	        statement.setInt(7, customer.getAddressID());

	        statement.executeUpdate();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } finally {
	        closeConnection(connection);
	    }
	}

	@Override
	public void registerAdmin(Admin admin) {
	    Connection connection = null;
	    try {
	        connection = getConnection();

	        String sql = "INSERT INTO Admin (adminID, firstName, lastName, email, password) VALUES (?, ?, ?, ?, ?)";

	        PreparedStatement statement = connection.prepareStatement(sql);
	        statement.setInt(1, generateAdminID()); // Generate and set the admin ID
	        statement.setString(2, admin.getFirstName());
	        statement.setString(3, admin.getLastName());
	        statement.setString(4, admin.getEmail());
	        statement.setString(5, admin.getPassword());

	        statement.executeUpdate();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } finally {
	        closeConnection(connection);
	    }
	}

	@Override
	public int generateCustomerID() {
	    // Generate a random 4-digit customer ID
	    return generateRandomID(4);
	}

	@Override
	public int generateAdminID() {
	    // Generate a random 3-digit admin ID
	    return generateRandomID(3);
	}

	private int generateRandomID(int length) {
	    Random random = new Random();
	    int min = (int) Math.pow(10, length - 1);
	    int max = (int) Math.pow(10, length) - 1;
	    return random.nextInt(max - min + 1) + min;
	}
	
	@Override
    public Customer getCustomerByEmail(String email) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Customer customer = null;

        try {
            connection = getConnection();

            String query = "SELECT * FROM Customer WHERE email = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setFirstName(resultSet.getString("firstName"));
                customer.setLastName(resultSet.getString("lastName"));
                customer.setEmail(resultSet.getString("email"));
                customer.setPassword(resultSet.getString("password"));
                // Set other fields if needed
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception
        } finally {
            // Close the resources: resultSet, preparedStatement, connection
            closeResources(resultSet, preparedStatement, connection);
        }

        return customer;
    }

    @Override
    public Admin getAdminByEmail(String email) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Admin admin = null;

        try {
            connection = getConnection();

            String query = "SELECT * FROM Admin WHERE email = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                admin = new Admin();
                admin.setAdminID(resultSet.getInt("adminID"));
                admin.setFirstName(resultSet.getString("firstName"));
                admin.setLastName(resultSet.getString("lastName"));
                admin.setEmail(resultSet.getString("email"));
                admin.setPassword(resultSet.getString("password"));
                // Set other fields if needed
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception
        } finally {
            // Close the resources: resultSet, preparedStatement, connection
            closeResources(resultSet, preparedStatement, connection);
        }

        return admin;
    }

    private void closeResources(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    @Override
    public void insertPayment(Payment payment) {
        String sql = "INSERT INTO Payment (paymentID, cardNum, expiration, CVV, orderID) VALUES (?, ?, ?, ?, ?)";

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, payment.getPaymentID());
            statement.setString(2, payment.getCardNum());
            statement.setString(3, payment.getExpir());
            statement.setString(4, payment.getCvv());
            statement.setInt(5, payment.getOrderID());

            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }
	
    @Override
    public List<Payment> getAllPayments() {
        List<Payment> payments = new ArrayList<>();
        String sql = "SELECT * FROM Payment";

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int paymentID = resultSet.getInt("paymentID");
                String cardNum = resultSet.getString("cardNum");
                String expiration = resultSet.getString("expiration");
                String cvv = resultSet.getString("CVV");
                int orderID = resultSet.getInt("orderID");

                Payment payment = new Payment(paymentID, cardNum, expiration, cvv, orderID);
                payments.add(payment);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return payments;
    }

    @Override
    public List<ProductOrder> getAllOrders() {
        List<ProductOrder> orders = new ArrayList<>();
        String sql = "SELECT * FROM ProductOrder";

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int customerID = resultSet.getInt("customerID");
                String dateOfPurchase = resultSet.getString("dateOfPurchase");
                double totalPrice = resultSet.getDouble("totalPrice");

                ProductOrder order = new ProductOrder();
                order.setId(id);
                order.setCustomerID(customerID);
                order.setDateOfPurchase(dateOfPurchase);
                order.setTotalPrice(totalPrice);

                orders.add(order);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return orders;
    }
    
	@Override
	public void insertOrder(ProductOrder order) {
	    String sql = "INSERT INTO ProductOrder (id, customerID, dateOfPurchase, totalPrice) VALUES (?, ?, ?, ?)";

	    Connection connection = null;
	    try {
	        connection = getConnection();
	        PreparedStatement statement = connection.prepareStatement(sql);
	        statement.setInt(1, order.getId());
	        statement.setInt(2, order.getCustomerID());
	        statement.setString(3, order.getDateOfPurchase());
	        statement.setDouble(4, order.getTotalPrice());

	        statement.executeUpdate();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } finally {
	        closeConnection(connection);
	    }
	}

}

