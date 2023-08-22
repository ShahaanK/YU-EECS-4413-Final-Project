package model;

public class Payment {
    private int paymentID;
    private String cardNum;
    private String expir;
    private String cvv;
    private int orderID; // We need to fix cause it comes from somewhere

    // Default constructor
    public Payment() {
    }

    public Payment(int paymentID, String cardNum, String expir, String cvv, int orderID) {
        this.paymentID = paymentID;
        this.cardNum = cardNum;
        this.expir = expir;
        this.cvv = cvv;
        this.orderID = orderID;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getExpir() {
        return expir;
    }

    public void setExpir(String expir) {
        this.expir = expir;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentID=" + paymentID +
                ", cardNum='" + cardNum + '\'' +
                ", expir='" + expir + '\'' +
                ", cvv='" + cvv + '\'' +
                ", orderID=" + orderID +
                '}';
    }
}
