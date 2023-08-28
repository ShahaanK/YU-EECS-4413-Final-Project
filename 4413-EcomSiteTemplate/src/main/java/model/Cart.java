package model;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cart {
 
   private List<Item> cart;  // List of Items
 
   // constructor
   public Cart() {
      cart = new ArrayList<Item>();
   }

// Add a Item into this Cart
   	public void add(String productID, String productName, String colour, int quantity, double price, String image, String category, String brand) {
    // Check if the id is already in the shopping cart
    Iterator<Item> iter = cart.iterator();
    while (iter.hasNext()) {
        Item item = iter.next();
        if (item.getProductID().equals(productID)) {
            // id found, increase quantity
            item.setQuantity(item.getQuantity() + quantity);
            return;
        }
    }
    // id not found, create a new Item
    Item i = new Item(productID, productName, colour, quantity, price, image, category, brand);
    cart.add(i);
}

// Update the quantity for the given id
   	public boolean update(String id, int newQty) {
    Iterator<Item> iter = cart.iterator();
    while (iter.hasNext()) {
        Item item = iter.next();
        if (item.getProductID().equals(id)) {
            // id found, increase quantity
            item.setQuantity(newQty);
            return true;
        }
    }
    return false;
}

// Remove a Item given its id
   	public void remove(String id) {
    Iterator<Item> iter = cart.iterator();
    while (iter.hasNext()) {
        Item item = iter.next();
        if (item.getProductID().equals(id)) {
            iter.remove();
            return;
        }
    }
}

 
   // Get the number of Items in this Cart
   public int size() {
      return cart.size();
   }
 
   // Check if this Cart is empty
   public boolean isEmpty() {
      return size() == 0;
   }
 
   // Return all the Items in a List<Item>
   public List<Item> getItems() {
      return cart;
   }
 
   // Remove all the items in this Cart
   public void clear() {
      cart.clear();
   }

   public double calculateTotalPrice() {
       double totalPrice = 0.0;

       for (Item item : cart) {
           totalPrice += item.getPrice() * item.getQuantity();
       }

       DecimalFormat decimalFormat = new DecimalFormat("0.00");
       return Double.parseDouble(decimalFormat.format(totalPrice));
   }
}