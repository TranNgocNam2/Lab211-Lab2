package Tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class MyTools {

    public static final Scanner sc = new Scanner(System.in);

    public static String readNonBlank(String message) {
        String input = "";
        do {
            System.out.print(message + "");
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Empty Text! Please enter input!");
            }
        } while (input.isEmpty());
        return input;
    }

    public static String readPattern(String message, String pattern) {
        String input = "";
        do {
            System.out.print(message + "");
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Empty Text! Please enter input!");
            }
            else if (input.matches(pattern)) {
                return input;
            } else {
                System.out.println("Invalid input. Please try again!");
            }
        } while (true);
    }

    public static List<String> readLinesFromFile(String filename) {
        List<String> list = new ArrayList<>();
        try {
            File f = new File(filename);
            if (!f.exists()) {
                System.out.println("File doesn't exist");
                return null;
            }
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String line;
            while ((line = bf.readLine()) != null) {
                list.add(line.trim());
            }
            bf.close();
            fr.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return list;
    }

    public static double getDoubleFromMinToMax(String welcome, double min, double max) {
        boolean check = true;
        double number = 0;
        do {
            try {
                System.out.print(welcome);
                number = Double.parseDouble(sc.nextLine());
                if (number < min) {
                    System.out.println("Number must be large than or equal to " + min + "!");
                } else if (number > max) {
                    System.out.println("Number must be smaller than or equal to " + max + "!");
                } else {
                    check = false;
                }
            } catch (NumberFormatException ex) {
                System.out.println("You enter the wrong number format! Please check again!");
            }
        } while (check || number < min || number > max);
        return number;
    }

    public static int getIntFromMinToMax(String welcome, int min, int max) {
        boolean check = true;
        int number = 0;
        do {
            try {
                System.out.print(welcome);
                number = Integer.parseInt(sc.nextLine());
                if (number < min) {
                    System.out.println("Number must be large than or equal to " + min + "!");
                } else if (number > max) {
                    System.out.println("Number must be smaller than or equal to " + max + "!");
                } else {
                    check = false;
                }
            } catch (NumberFormatException ex) {
                System.out.println("You enter the wrong number format! Please check again!");
            }
        } while (check || number < min || number > max);
        return number;
    }

    public static void writeFile(String filename, List list) {
        if (list.isEmpty()) {
            System.out.println("The list is empty");
            return;
        }
        try {
            File f = new File(filename);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Object x : list) {
                pw.write(x.toString());
            }
            pw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
