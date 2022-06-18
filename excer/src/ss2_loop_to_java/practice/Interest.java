package ss2_loop_to_java.practice;

import java.util.Scanner;

public class Interest {
    public static void main(String[] args) {
        System.out.println("Tính lãi ngân hàng");
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số tiền bạn muốn gửi: ");
        int money = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập % lãi suất: ");
        double interest = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập số tháng muốn gửi: ");
        int month = Integer.parseInt(sc.nextLine());
        double total = 0;
        for (int i = 0; i < month; i++) {
            total +=  money * (interest / 100) / 12 * month;
        }
        System.out.println("Tổng tiền là: " + total);
    }
}
