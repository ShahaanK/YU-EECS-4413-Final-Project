package model;

public class ProductOrderItem {
    private String orderID;
    private String itemID;

    public ProductOrderItem() {
    }

    public ProductOrderItem(String orderID, String itemID) {
        this.orderID = orderID;
        this.itemID = itemID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    @Override
    public String toString() {
        return "ProductOrderItem{" +
                "orderID='" + orderID + '\'' +
                ", itemID='" + itemID + '\'' +
                '}';
    }
}
