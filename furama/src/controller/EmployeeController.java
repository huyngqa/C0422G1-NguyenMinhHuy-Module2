package controller;

import java.util.Scanner;

public class EmployeeController {
    private static Scanner scanner = new Scanner(System.in);

    public static void displayEmployeeMenu() {
        System.out.println("Select function " +
                "\n 1. Display list employees" +
                "\n 2. Add new employee" +
                "\n 3. Edit Employee" +
                "\n 4. Return main menu");
        System.out.print("Your choose function: ");
        String choose = scanner.nextLine();
        System.out.println();
        switch (choose) {
            case "1":
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
