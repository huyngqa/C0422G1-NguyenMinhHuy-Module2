package common;

import java.util.Scanner;

public class TypeInformation {
    private static Scanner scanner = new Scanner(System.in);
    public static String getTypeSex() {
        String sex = "";
        do {
            System.out.println("Chọn giới tính\n" +
                    "1. Nam\n" +
                    "2. Nữ\n" +
                    "3. LGBTS");
            System.out.print("Mời bạn chọn: ");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    sex = "nam";
                    break;
                case "2":
                    sex = "nữ";
                    break;
                case "3":
                    sex = "lgbts";
                    break;
                default:
                    System.out.println("Bạn chọn chưa đúng! Vui lòng chọn lại");
            }
        } while (sex.equals(""));
        return sex;
    }
    public static String getTypeCustomer() {
        String typeCustomer = "";
        String choose;
        do {
            System.out.println("Chọn loại khách\n" +
                    "1. Diamond.\n" +
                    "2. Platinum.\n" +
                    "3. Gold.\n" +
                    "4. Silver.\n" +
                    "5. Member.");
            System.out.print("Mời bạn chọn: ");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    typeCustomer = "Diamond";
                    break;
                case "2":
                    typeCustomer = "Platinum";
                    break;
                case "3":
                    typeCustomer = "Gold";
                    break;
                case "4":
                    typeCustomer = "Silver";
                    break;
                case "5":
                    typeCustomer = "Member";
                    break;
                default:
                    System.out.println("Bạn chọn không đúng thông tin, mời bạn chọn lại");
            }
        } while (typeCustomer.equals(""));
        return typeCustomer;
    }
    public static String getTypeLevel() {
        String level = "";
        String choose;
        do {
            System.out.println("Nhập trình độ\n" +
                    "1. Trung cấp.\n" +
                    "2. Cao đẳng.\n" +
                    "3. Đại học.\n" +
                    "4. Sau đại học.");
            System.out.print("Mời bạn chọn: ");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    level = "Trung cấp";
                    break;
                case "2":
                    level = "Cao đẳng";
                    break;
                case "3":
                    level = "Đại học";
                    break;
                case "4":
                    level = "Sau đại học";
                    break;
                default:
                    System.out.println("Bạn chọn không đúng thông tin, mời bạn chọn lại");
            }
        } while (level.equals(""));
        return level;
    }
    public static String getTypePosition() {
        String position = "";
        String choose = "";
        do {
            System.out.println("Nhập vị trí công việc\n" +
                    "1. Lễ tân.\n" +
                    "2. Phục vụ.\n" +
                    "3. Chuyên viên.\n" +
                    "4. Giám sát.\n" +
                    "5. Quản lý.\n" +
                    "6. Giám đốc.");
            System.out.print("Mời bạn chọn: ");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    position = "Lễ tân";
                    break;
                case "2":
                    position = "Phục vụ";
                    break;
                case "3":
                    position = "Chuyên viên";
                    break;
                case "4":
                    position = "Giám sát";
                    break;
                case "5":
                    position = "Quản lý";
                    break;
                case "6":
                    position = "Giám đốc";
                    break;
                default:
                    System.out.println("Bạn chọn không đúng thông tin, mời bạn chọn lại");
            }
        } while (position.equals(""));
        return position;
    }
}
