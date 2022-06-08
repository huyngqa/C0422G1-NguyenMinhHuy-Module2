package ss2_loop_to_java.thuc_hanh;

import java.util.Scanner;

public class CommonFactor {
    public static void main(String[] args) {
        System.out.println("Ước chung lớn nhất của 2 số");
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số a: ");
        int a = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập số b: ");
        int b = Integer.parseInt(sc.nextLine());
        if (a == 0 || b == 0) {
            System.out.println("Không có ước chung lớn nhất");
        } else {
            while (a != b) {
                if(a > b) {
                    a = a - b;
                } else {
                    b = b - a;
                }
            }
            System.out.println("Ước chung lớn nhất là: " + a);
        }
    }
}
