package ss2_loop_to_java.excercise;

import java.util.Scanner;

public class Polygon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Vẽ hình chữ nhật");
            System.out.println("2. Vẽ tam giác vuông "
                    + "(Góc là hình vuông ở 4 góc khác nhau: "
                    + "trên cùng bên trái, trên cùng bên phải, dưới cùng bên trái, dưới cùng bên phải)");
            System.out.println("3. Vẽ hình tam giác cân");
            System.out.println("4. Thoát");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Vẽ hình chữ nhật");
                    for (int i = 1; i <=3; i++) {
                        for (int j = 1; j < 7; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("Vẽ tam giác vuông góc trên cùng bên trái");
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 5; j >= i; j--) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    System.out.println("Vẽ tam giác vuông góc trên cùng bên phải");
                    for (int i = 5; i >= 1; i--) {
                        for (int j = 5; j > i ; j--) {
                            System.out.print(" ");
                        }
                        for (int j = 1; j <= i ; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    System.out.println("Vẽ tam giác vuông góc dưới cùng bên trái");
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    System.out.println("Vẽ tam giác vuông góc dưới cùng bên phải");
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 5; j > i; j--) {
                            System.out.print(" ");
                        }
                        for (int j = 1; j <=i ; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.println("Vẽ hình tam giác cân"); //isoscles
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 5 - 1; j >= i; j--) {
                            System.out.print(" ");
                        }
                        for (int j = 1; j <= i + (i - 1); j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                default:
                    System.out.println("Bạn đã thoát khỏi chương trình");
            }
        } while (choice != 4);
    }
}
