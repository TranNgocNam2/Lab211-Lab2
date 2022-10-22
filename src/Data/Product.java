/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author ADMIN
 */
public class Product implements Comparable<Product> {

    public static final String SEPARATOR = ",";
    private String productID;
    private String productName;
    private double unitPrice;
    private int quantity;
    private String status;

    public Product() {
    }

    public Product(String line) {
        String[] parts = line.split(this.SEPARATOR);
        productID = parts[0].trim();
        productName = parts[1].trim();
        status = parts[4].trim();
    }

    public Product(String productID, String productName, double unitPrice, int quantity, String status) {
        this.productID = productID;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.status = status;
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

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return productID + ", " + productName + ", " + unitPrice + ", " + quantity + ", " + status + "\n";
    }

    @Override
    public int compareTo(Product t) {
        if (t.getQuantity() == this.getQuantity()) {
            if (t.getUnitPrice() > this.getUnitPrice()) {
                return -1;
            } else if (t.getUnitPrice() == this.getUnitPrice()) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return t.getQuantity() - this.getQuantity();
        }
    }
}
