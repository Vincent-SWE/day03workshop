package sg.edu.nus.iss;

import java.io.Console;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */

    // Entry point
    public static void main(String[] args) {
        String dirPath = "\\data2";
        String fileName = "";


        File newDirectory = new File(dirPath);
        if (newDirectory.exists()) {
            System.out.println("Directory already exists ");
        } else { 
            newDirectory.mkdir();
        }

        System.out.println("Welcome to My Shopping Cart");

        List<String> cartItems = new ArrayList<String>();
        
        Console con = System.console();
        String input ="";

        while(!input.equals("quit")) {
            input = con.readLine("What do you want to perform? Type 'quit' to exit the program\n");
        

        switch(input) {
            case "help":
                displayMessage("'list' to show a list of itmes in shopping cart");
                displayMessage("'login' <name> to access your cart");
                displayMessage("'add' <item> to add items to your shopping cart");
                displayMessage("'delete' <item #> to remove item from your shopping cart");
                displayMessage("'quit' to exit this program");
                break;
            case "list":
                if (cartItems.size() > 0) {
                    for (String item: cartItems) {
                        System.out.println(item);
                    }
                } else {
                    displayMessage("Your cart is empty."); 
                }
                break;
            case "users":
                break;
            default:
        }
    }
        if (input.startsWith("add")) {
            input = input.replace(',' ,' ');

            // storing value
            String strValue = "";
            // because in add orange, a is index 0, d is index 2, o is index 4
            Scanner scanner = new Scanner(input.substring(4));

            while(scanner.hasNext()) {
                strValue = scanner.next();
                cartItems.add(strValue);
            }
        }



    }

    public static void displayMessage(String message) {
        System.out.println(message);
    }
}
