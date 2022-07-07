package controller;

import java.util.Scanner;

public class MainController {
        private static Scanner scanner = new Scanner(System.in);

        public static void displayMainMenu() {
            System.out.println();
            String choose = "";
            do {
                System.out.println("Chọn chức năng theo số (để tiếp tục)" +
                        "\n 1. Thêm mới" +
                        "\n 2. Xoá" +
                        "\n 3. Xem danh sách các tài khoản ngân hàng" +
                        "\n 4. Tìm kiếm" +
                        "\n 5. Thoát khỏi chương trình");
                System.out.print("Lựa chọn của bạn: ");
                choose = scanner.nextLine();
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
                    case "5":
                        System.out.println("Bạn đã thoát khỏi chương trình");
                        break;
                    default:
                        System.out.println("Lựa chọn của bạn chưa có! Mời bạn chọn lại");
                }
            } while (!choose.equals("6"));
        }

}
