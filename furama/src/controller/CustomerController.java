package controller;

import service.CustomerService;
import service.impl.CustomerServiceImpl;

import java.util.Scanner;

public class CustomerController {
    private static Scanner scanner = new Scanner(System.in);
    private static CustomerService customerService = new CustomerServiceImpl();
    public static void displayCustomerMenu() {
            System.out.println("Select function " +
                    "\n 1. Display list customer" +
                    "\n 2. Add new customer" +
                    "\n 3. Edit customer" +
                    "\n 4. Return main menu");
            System.out.print("Your choose function: ");
            String choose = scanner.nextLine();
            System.out.println();
            switch (choose) {
                case "1":
                    customerService.display();
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                default:
                    System.out.println("Your choose is not exist");
            }
    }
}
