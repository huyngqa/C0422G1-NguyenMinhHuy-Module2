package ss1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class Currency {
    public static void main(String[] args) {
        System.out.println("Chuyển đổi tiền tệ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tiền USD bạn muốn đổi: ");
        int money = Integer.parseInt(sc.nextLine());
        System.out.println(money + "usd = " + money * 23000 + "đ");
    }
}
