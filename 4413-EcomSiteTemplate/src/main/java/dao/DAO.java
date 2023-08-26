package dao;

import java.util.List;

import model.Item;

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

    
	
}
