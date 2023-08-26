package model;

public class ProductOrder {
    private int id;
    private int customerID;
    private String dateOfPurchase;
    private double totalPrice;

    // Getters and setters for all fields

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "ProductOrder - ID: " + id + ", Customer ID: " + customerID + ", Date of Purchase: "
                + dateOfPurchase + ", Total Price: " + totalPrice;
    }
}
