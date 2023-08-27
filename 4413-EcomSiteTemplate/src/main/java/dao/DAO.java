package dao;

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
    
    public void insertPayment(Payment payment);
    boolean insertCustomer(Customer customer);

    // Method to insert admin information
    boolean insertAdmin(Admin admin);
    
    public List<Payment> getAllPayments();
    public List<ProductOrder> getAllOrders();
    
    List<Item> getRandomItems(int count);
	
}
