package ss3_array_and_method.bai_tap;

import java.util.Scanner;

public class StringCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào một chuỗi: ");
        String str = scanner.nextLine();
        System.out.print("Nhập vào kí tự bạn muốn kiểm tra: ");
        char c = scanner.nextLine().charAt(0);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
            }
        }
        System.out.println("Số lần kí tự bạn nhập xuất hiện trên chuỗi là: " + count);
    }
}
