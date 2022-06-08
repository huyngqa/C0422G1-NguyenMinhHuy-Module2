package ss2_loop_to_java.thuc_hanh;

import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        System.out.println("Kiểm tra số nguyên tố");
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        if (num < 2) {
            System.out.println(num + " không phải là số nguyên tố");
        } else {
            for (int i = 2; i < Math.sqrt(num); i++) {
                if (num % i == 0) {
                    System.out.println(num + " không phải là số nguyên tố");
                }
            }
            System.out.println(num + " là số nguyên tố");
        }
    }
}
