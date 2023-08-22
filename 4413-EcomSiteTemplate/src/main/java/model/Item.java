package model;

public class Item {
    private String productID;
    private String productName;
    private String colour;
    private String brand;
    private int quantity;
    private double price;
    private String image;

    public Item() {
    }

    public Item(String productID, String productName, String colour, String brand, int quantity, double price, String image) {
        this.productID = productID;
        this.productName = productName;
        this.colour = colour;
        this.brand = brand;
        this.quantity = quantity;
        this.price = price;
        this.image = image;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Item{" +
                "productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", colour='" + colour + '\'' +
                ", brand='" + brand + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }
}
