package MNG;

import Data.Product;
import Data.ProductList;
import Interfaces.IProduct;
import Tools.MyTools;
import java.util.Collections;

/**
 *
 * @author ADMIN
 */
public class ProductManager implements IProduct {

    ProductList proList = new ProductList();
    boolean changed = false;

    public ProductManager() {
        proList.loadProductFromFile();
    }

    @Override
    public void printAllProduct() {
        if (proList.getpList().isEmpty()) {
            System.out.println("Empty List!");
        } else {
            for (int i = 0; i < proList.getpList().size(); i++) {
                System.out.println("  " + (i + 1) + ": " + proList.getProduct(i).toString());
            }
        }
    }

    @Override
    public void createProduct() {
        String ID, name, status;
        double price;
        int quantity, pos;
        do {
            ID = MyTools.readPattern("Enter product's ID(Pxxxx): ", "P\\d{4}");
            pos = proList.checkProductID(ID);
            if (pos >= 0) {
                System.out.println("Product's ID is duplicated!");
            }
        } while (pos >= 0);
        do {
            name = MyTools.readNonBlank("Enter product's name: ").toUpperCase();
            pos = proList.checkProductName(name);
            if(pos >= 0){
                System.out.println("Product name is duplicated!");
            }
        } while (pos >= 0);
        price = MyTools.getDoubleFromMinToMax("Enter product's price: ", 0, 10000);
        quantity = MyTools.getIntFromMinToMax("Enter product quantity: ", 0, 1000);
        status = MyTools.readPattern("Enter product status (Available or Not Available): ", "(Available)|(Not Available)");
        proList.addProduct(new Product(ID, name, price, quantity, status));
        System.out.println("Added new product successfully!");
        changed = true;
        int num = MyTools.getIntFromMinToMax("Do you want to add more product ?\n  1: Yes\n  2: No\n    Your Choice: ", 1, 2);
        if (num == 1) {
            createProduct();
        } else {
            System.out.println("Return to main menu!");
        }
    }

    @Override
    public void checkProduct() {
        String name = MyTools.readNonBlank("Enter product name you want to check: ").toUpperCase();
        int pos = 0;
        pos = proList.checkProductName(name);
        if (pos >= 0) {
            System.out.println("Exist Product!");
        } else {
            System.out.println("Have no any Product!");
        }
        int num = MyTools.getIntFromMinToMax("Do you want to check more product ?\n  1: Yes\n  2: No\n    Your Choice: ", 1, 2);
        if (num == 1) {
            checkProduct();
        } else {
            System.out.println("Return to main menu!");
        }
    }

    @Override
    public void searchProduct() {
        String name = MyTools.readNonBlank("Enter product name you want to search: ").toUpperCase();
        int pos = proList.containProductName(name);
        if (pos >= 0) {
            proList.printProductName(name);
        } else {
            System.out.println("Product name does not exist!");
        }
        int num = MyTools.getIntFromMinToMax("Do you want to search more product ?\n  1: Yes\n  2: No\n    Your Choice: ", 1, 2);
        if (num == 1) {
            searchProduct();
        } else {
            System.out.println("Return to main menu!");
        }
    }

    @Override
    public void updateProduct() {
        String ID = MyTools.readPattern("Enter product ID (Pxxxx) you want to update: ", "P\\d{4}");
        int pos = proList.checkProductID(ID);
        if (pos >= 0) {
            String newName = MyTools.readNonBlank("Enter new product name: ").toUpperCase();
            double newPrice = MyTools.getDoubleFromMinToMax("Enter new product price: ", 0, 10000);
            int newQuantity = MyTools.getIntFromMinToMax("Enter new product quantity: ", 0, 1000);
            String newStatus = MyTools.readPattern("Enter product status (Available or Not Available): ", "(Available)|(Not Available)");
            proList.updateProduct(newName, ID, newPrice, newQuantity, newStatus);
            System.out.println("Updated product successfully!");
            changed = true;
        } else {
            System.out.println("Product ID is not exist!");
        }
        int num = MyTools.getIntFromMinToMax("Do you want to update more product ?\n  1: Yes\n  2: No\n    Your Choice: ", 1, 2);
        if (num == 1) {
            updateProduct();
        } else {
            System.out.println("Return to main menu!");
        }
    }

    @Override
    public void deleteProduct() {
        String ID = MyTools.readPattern("Enter product ID (Pxxxx) you want to delete: ", "P\\d{4}");
        int pos = proList.checkProductID(ID);
        if (pos >= 0) {
            proList.deleteProduct(ID);
            System.out.println("Delete product successfully!");
            changed = true;
            int num = MyTools.getIntFromMinToMax("Do you want to delete more product ?\n  1: Yes\n  2: No\n    Your Choice: ", 1, 2);
            if (num == 1) {
                deleteProduct();
            } else {
                System.out.println("Return to main menu!");
            }
        } else {
            System.out.println("Product ID does not exist!");
        }
    }

    @Override
    public void saveProduct() {
        proList.saveProduct();
        System.out.println("Save product succesfully!");
    }

    @Override
    public void printProductFromFile() {
        ProductList proList2 = new ProductList();
        proList2.loadProductFromFile();
        Collections.sort(proList2.getpList());
        if (proList2.getpList().isEmpty()) {
            System.out.println("Empty List!");
        } else {
            for (int i = 0; i < proList2.getpList().size(); i++) {
                System.out.println("   " + (i + 1) + ": " + proList2.getProduct(i).toString());
            }
        }
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }
}
