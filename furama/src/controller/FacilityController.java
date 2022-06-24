package controller;

import java.util.Scanner;

public class FacilityController {
    private static Scanner scanner = new Scanner(System.in);
    public static void displayFacilityMenu() {
            System.out.println("Select function " +
                    "\n 1. Display list facility" +
                    "\n 2. Add new facility" +
                    "\n 3. Display list facility maintenance" +
                    "\n 4. Return main menu");
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
                default:
                    System.out.println("Your choose is not exist");
            }
    }
}
