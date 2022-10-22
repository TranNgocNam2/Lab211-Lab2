/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Tools.MyTools;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ProductList extends Product {

    public ArrayList<Product> pList = new ArrayList<>();
    private final String dataFile = "products.txt";

    public Product getProduct(int i) {
        return pList.get(i);
    }

    public ArrayList getpList() {
        return pList;
    }

    public void setpList(ArrayList pList) {
        this.pList = pList;
    }

    public void loadProductFromFile() {
        List<String> lines = MyTools.readLinesFromFile(dataFile);
        for (String x : lines) {
            String[] a = x.split(",");
            Product pd = new Product(a[0].trim(), a[1].trim(), Double.parseDouble(a[2].trim()), Integer.parseInt(a[3].trim()), a[4].trim());
            pList.add(pd);
        }
    }

    public void addProduct(Product pd) {
        pList.add(pd);
    }

    public int checkProductName(String checkName) {
        for (int i = 0; i < pList.size(); i++) {
            if (pList.get(i).getProductName().equals(checkName)) {
                return i;
            }
        }
        return -1;
    }

    public int checkProductID(String pID) {
        for (int i = 0; i < pList.size(); i++) {
            if (pList.get(i).getProductID().equals(pID)) {
                return i;
            }
        }
        return -1;
    }

    public int containProductName(String containName) {
        for (int i = 0; i < pList.size(); i++) {
            if (pList.get(i).getProductName().contains(containName)) {
                return i;
            }
        }
        return -1;
    }

    public void printProductName(String containName) {
        for (int i = 0; i < pList.size(); i++) {
            if (pList.get(i).getProductName().contains(containName)) {
                System.out.println(" - " + pList.get(i).getProductName());
            }
        }
    }

    public void printProduct() {
    }

    public void updateProduct(String newName, String newID, double newPrice, int newQuantity, String newStatus) {
        int pos = checkProductID(newID);
        if (pos > 0) {
            pList.get(pos).setProductName(newName);
            pList.get(pos).setUnitPrice(newPrice);
            pList.get(pos).setQuantity(newQuantity);
            pList.get(pos).setStatus(newStatus);
        } else {
            System.out.println("Product's ID does not exit!");
        }
    }

    public void deleteProduct(String newID) {
        int pos = checkProductID(newID);
        if (pos > 0) {
            pList.remove(pos);
        } else {
            System.out.println("Product's ID does not exit!");
        }
    }

    public void saveProduct() {
        MyTools.writeFile(dataFile, pList);
    }
}
