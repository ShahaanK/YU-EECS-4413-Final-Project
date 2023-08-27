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
		String mediya = "";
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

		String sql = "SELECT * from Item"
				+ "where item.brand = '" + name +"'";
		
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
	    String sql = "SELECT * FROM Item ORDER BY price " + (ascending ? "ASC" : "DESC");

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
	    String sql = "SELECT * FROM Item ORDER BY price " + (descending ? "DESC" : "ASC");

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
	    String sql = "SELECT * FROM Item ORDER BY productName " + (ascending ? "ASC" : "DESC");

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
	public boolean insertCustomer(Customer customer) {
	    String sql = "INSERT INTO Customer (firstName, lastName, email, phone, password, addressID) VALUES (?, ?, ?, ?, ?, ?)";

	    Connection connection = null;
	    try {
	        connection = getConnection();
	        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	        statement.setString(1, customer.getFirstName());
	        statement.setString(2, customer.getLastName());
	        statement.setString(3, customer.getEmail());
	        statement.setString(4, customer.getPhone());
	        statement.setString(5, customer.getPassword());
	        statement.setInt(6, customer.getAddressID());

	        int rowsAffected = statement.executeUpdate();

	        if (rowsAffected > 0) {
	            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                    int generatedId = generatedKeys.getInt(1);
	                    customer.setId(generatedId); // Set the generated ID in the Customer object
	                    return true;
	                }
	            }
	        }

	        return false;
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        return false;
	    } finally {
	        closeConnection(connection);
	    }
	}

	@Override
	public boolean insertAdmin(Admin admin) {
	    String sql = "INSERT INTO Admin (firstName, lastName, email, password) VALUES (?, ?, ?, ?)";

	    Connection connection = null;
	    try {
	        connection = getConnection();
	        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	        statement.setString(1, admin.getFirstName());
	        statement.setString(2, admin.getLastName());
	        statement.setString(3, admin.getEmail());
	        statement.setString(4, admin.getPassword());

	        int rowsAffected = statement.executeUpdate();

	        if (rowsAffected > 0) {
	            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                    int generatedId = generatedKeys.getInt(1);
	                    admin.setAdminID(generatedId); // Set the generated ID in the Admin object
	                    return true;
	                }
	            }
	        }

	        return false;
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        return false;
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
	            Payment payment = new Payment();
	            payment.setPaymentID(resultSet.getInt("paymentID"));
	            payment.setCardNum(resultSet.getString("cardNum"));
	            payment.setExpir(resultSet.getString("expiration"));
	            payment.setCvv(resultSet.getString("CVV"));
	            payment.setOrderID(resultSet.getInt("orderID"));
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
	            ProductOrder order = new ProductOrder();
	            order.setId(resultSet.getInt("id"));
	            order.setCustomerID(resultSet.getInt("customerID"));
	            order.setDateOfPurchase(resultSet.getString("dateOfPurchase"));
	            order.setTotalPrice(resultSet.getDouble("totalPrice"));
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



}

