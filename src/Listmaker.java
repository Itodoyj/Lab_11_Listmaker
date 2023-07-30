import java.util.Scanner;
import java.util.ArrayList;
public class Listmaker {
        private static final Scanner scanner = new Scanner(System.in);
        private static final ArrayList<String> itemList = new ArrayList<>();

        public static void main(String[] args) {
            boolean quit = false;

            while (!quit) {
                displayMenu();
                String choice = SafeInput.getRegExString(scanner, "Enter your choice (A/D/P/Q): ", "[AaDdPpQq]");

                switch (choice.toUpperCase()) {
                    case "A":
                        addItem();
                        break;
                    case "D":
                        deleteItem();
                        break;
                    case "P":
                        printList();
                        break;
                    case "Q":
                        quit = quitConfirmation();
                        break;
                }
            }
            scanner.close();
        }

        private static void displayMenu() {
            System.out.println("Menu:");
            System.out.println("A - Add an item to the list");
            System.out.println("D - Delete an item from the list");
            System.out.println("P - Print the list");
            System.out.println("Q - Quit the program");
        }

        private static void addItem() {
            String item = SafeInput.getRegExString(scanner, "Enter the item to add: ", ".*");
            itemList.add(item);
            System.out.println("Item added successfully!");
        }

        private static void deleteItem() {
            if (itemList.isEmpty()) {
                System.out.println("The list is empty. Nothing to delete.");
                return;
            }

            System.out.println("Current items in the list:");
            for (int i = 0; i < itemList.size(); i++) {
                System.out.println((i + 1) + ". " + itemList.get(i));
            }

            int itemNumber = SafeInput.getInt(scanner, "Enter the number of the item to delete: ", 1, itemList.size());
            itemList.remove(itemNumber - 1);
            System.out.println("Item deleted successfully!");
        }

        private static void printList() {
            if (itemList.isEmpty()) {
                System.out.println("The list is empty.");
            } else {
                System.out.println("Current items in the list:");
                for (int i = 0; i < itemList.size(); i++) {
                    System.out.println((i + 1) + ". " + itemList.get(i));
                }
            }
        }

        private static boolean quitConfirmation() {
            return SafeInput.getYesNoInput(scanner, "Are you sure you want to quit (Y/N)? ");
        }
}


