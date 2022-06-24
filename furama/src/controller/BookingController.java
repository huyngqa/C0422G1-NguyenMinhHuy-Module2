package controller;

import java.util.Scanner;

public class BookingController {
    private static Scanner scanner = new Scanner(System.in);
    public static void displayBookingMenu() {
            System.out.println("Select function " +
                    "\n 1. Display list booking" +
                    "\n 2. Add new booking" +
                    "\n 3. Create new contracts" +
                    "\n 4. Display list contracts" +
                    "\n 5. Edit contracts" +
                    "\n 6. Return main menu");
            System.out.print("Your choose function: ");
            int choose = Integer.parseInt(scanner.nextLine());
            System.out.println();
            switch (choose) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Your choose is not exist");
            }
    }
}
