package controller;

import java.util.Scanner;

public class MainController {
    private static Scanner scanner = new Scanner(System.in);
    public static void displayMainMenu() {
        boolean temp = true;
        do {
            System.out.println("Select function " +
                    "\n 1. Employee Management" +
                    "\n 2. Customer Management" +
                    "\n 3. Facility Management" +
                    "\n 4. Booking Management" +
                    "\n 5. Promotion Management" +
                    "\n 6. Exit");
            System.out.print("Your choose function: ");
            int choose = Integer.parseInt(scanner.nextLine());
            System.out.println();
            switch (choose) {
                case 1:
                    EmployeeController.displayEmployeeMenu();
                    break;
                case 2:
                    CustomerController.displayCustomerMenu();
                    break;
                case 3:
                    FacilityController.displayFacilityMenu();
                    break;
                case 4:
                    BookingController.displayBookingMenu();
                    break;
                case 5:
                    PromotionController.displayPromotionMenu();
                    break;
                case 6:
                    System.out.println("Exit Menu");
                    temp = false;
                    break;
                default:
                    System.out.println("Your choose is not exist");
            }
        }while (temp);
    }
}
