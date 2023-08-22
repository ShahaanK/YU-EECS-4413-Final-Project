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
		String tracy = "";
		return DriverManager.getConnection("jdbc:sqlite:" + shahaan);
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
		String sql = "select * from book inner join author on book.id = author.book_id "
				+ "inner join category on book.category_id = category.id";

		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {


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
		return null;
	}

	@Override
	public List<Item> findAllBottoms() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> getSortHiLo(boolean ascending) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> getSortLoHi(boolean decesending) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> getSortAZ(boolean ascending) {
		// TODO Auto-generated method stub
		return null;
	}

}
