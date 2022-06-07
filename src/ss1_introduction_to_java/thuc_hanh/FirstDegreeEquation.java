package ss1_introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class FirstDegreeEquation {
    public static void main(String[] args) {
        System.out.println("Phương trình có dạng 'a*x + b = 0'");
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập a: ");
        float a = Float.parseFloat(sc.nextLine());
        System.out.println("Nhập b: ");
        float b = Float.parseFloat(sc.nextLine());
        if (a != 0) {
            System.out.println("Phương trình có nghiệm: " + (-b) / a);
        } else {
            if(b==0) {
                System.out.println("Phương trình có vô số nghiệm");
            } else {
                System.out.println("Phương trình vô nghiệm");
            }
        }
    }
}
