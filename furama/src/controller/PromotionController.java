package controller;

import java.util.Scanner;

public class PromotionController {
    private static Scanner scanner = new Scanner(System.in);
    public static void displayPromotionMenu() {
            System.out.println("Select function " +
                    "\n 1. Display list customers use service" +
                    "\n 2. Display list customers get voucher" +
                    "\n 3. Return main menu");
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
                default:
                    System.out.println("Your choose is not exist");
            }
    }
}
