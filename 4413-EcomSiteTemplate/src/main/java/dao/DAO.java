package dao;

import java.sql.SQLException;
import java.util.List;

import model.Item;
import model.Payment;
import model.ProductOrder;
import model.Customer; // Import the Customer class
import model.Admin; // Import the Admin class

public interface DAO {
	
	//Make methods that we need.

	public List<Item> findAllItems();
	
	public List<Item> findAllTops();
	
	public List<Item> findAllBottoms();
	
	public List<Item> findByBrand(String name); //S
		
	public List<Item> searchKeyword(String keyWord);
    
	public List<Item> getSortHiLo(boolean ascending); //S
    
    public List<Item> getSortLoHi(boolean decesending); //S

	public List<Item> getSortAZ(boolean ascending);
	
	public List<Item> getSortZA(boolean decesending);

    public List<Item> getImage();
    
    List<Item> getRandomItems(int count);
    
    // Register a customer
    void registerCustomer(Customer customer);

    // Register an admin
    void registerAdmin(Admin admin);

    // Generate a random customer ID (4 digits)
    int generateCustomerID();

    // Generate a random admin ID (3 digits)
    int generateAdminID();
    
    Customer getCustomerByEmail(String email);
    
    Admin getAdminByEmail(String email);
    
    public void insertPayment(Payment payment);
    
    public List<Payment> getAllPayments();
    public List<ProductOrder> getAllOrders();
    


}
