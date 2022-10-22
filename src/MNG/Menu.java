package MNG;

import Tools.MyTools;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Menu extends ArrayList<String> {

    public Menu() {
        super();
    }

    public Menu(String[] items) {
        super();
        for (String item : items) {
            this.add(item);
        }
    }

    public String getChoice(String title) {
        System.out.println(title);
        for (int i = 0; i < this.size(); i++) {
            System.out.println((i + 1) + " - " + this.get(i));
        }
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Your choice: ");
                return sc.nextLine();
            } catch (Exception ex) {
                System.out.println("Your choice is invalid!");
            }
        } while (true);
    }

    public static void showMenu() {
        String[] options = {"Print.", "Create a Product.", "Check exist Product.", "Search Product's information by Name.", "Update Product:\n 5.1: Update Product\n 5.2: Delete Product", "Save Products to file.", "Print list Products from the file.", "Others - Quits"};
        Menu mnu = new Menu(options);
        ProductManager pM = new ProductManager();
        String choice;
        do {
            choice = mnu.getChoice("--------------------Managing products--------------------");
            switch (choice) {
                case "1":
                    pM.printAllProduct();
                    break;
                case "2":
                    pM.createProduct();
                    break;
                case "3":
                    pM.checkProduct();
                    break;
                case "4":
                    pM.searchProduct();
                    break;
                case "5":
                    System.out.println("Please input 5.1 or 5.2! Try again!");
                    System.out.println();
                    break;
                case "5.1":
                    pM.updateProduct();
                    break;
                case "5.2":
                    pM.deleteProduct();
                    break;
                case "6":
                    pM.saveProduct();
                    break;
                case "7":
                    pM.printProductFromFile();
                    break;
                default:
                    if (pM.isChanged()) {
                        System.out.println("Data is changed. Save to file ?");
                        int num = MyTools.getIntFromMinToMax("  1: Yes\n  2: No\n    Your Choice: ", 1, 2);
                        if (num == 1) {
                            pM.saveProduct();
                            System.out.println("--------------------Bye--------------------");
                            return;
                        } else {
                            System.out.println("--------------------Bye--------------------");
                            return;
                        }
                    }
            }
        } while (choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4") || choice.equals("5") || choice.equals("5.1")
                || choice.equals("5.2") || choice.equals("6") || choice.equals("7"));
        System.out.println("----------GoodBye----------");

    }
}
