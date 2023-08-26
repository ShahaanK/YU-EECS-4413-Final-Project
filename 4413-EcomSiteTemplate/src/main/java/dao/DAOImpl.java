package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ProductOrderItem;
import model.Item;

public class DAOImpl implements DAO {

	//------------Establishing Connection------------------------
	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException ex) {
		}
	}

	// complete this method
	private Connection getConnection() throws SQLException {
		String shahaan = "C:\\Users\\shaha\\OneDrive\\Desktop\\4413 - E-Comm\\Project\\4413DB.db";
		String tracy = "/Users/miaonya/Downloads";
		String mediya = "";
		return DriverManager.getConnection("jdbc:sqlite:" + shahaan);//replace the name with yours's

	}

	private void closeConnection(Connection connection) {
		if (connection == null)
			return;
		try {
			connection.close();
		} catch (SQLException ex) {
		}
	}
	//---------------------------------------------

	@Override
	public List<Item> findAllItems() {
		List<Item> result = new ArrayList<Item>();

		// join 3 tables to get needed info
		String sql = "SELECT * from Item";

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

	    String sql = " ";// for searching and put the image to the web

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

}
