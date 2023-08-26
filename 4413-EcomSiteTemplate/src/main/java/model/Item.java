package model;

public class Item {
    private String productID;
    private String productName;
    private String colour;
    private String category;
    private String brand;
    private int quantity;
    private double price;
    private String image;


    public Item(String productID, String productName, String colour, int quantity, double price, String image, String category, String brand) {
        this.productID = productID;
        this.productName = productName;
        this.colour = colour;
        this.quantity = quantity;
        this.price = price;
        this.image = image;
        this.category = category;
        this.brand = brand;
    }
    
    public Item() {}

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
	public String getCategory() {
        return category;
		
	}
	public void setCategory(String category) {
		this.category = category;
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
