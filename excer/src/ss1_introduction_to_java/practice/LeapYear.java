package ss1_introduction_to_java.practice;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        System.out.println("Kiểm tra năm nhuận");
        System.out.println();

        Scanner sc = new Scanner(System.in);
        int year = Integer.parseInt(sc.nextLine());
        boolean tmp = false;

        if(year % 4 == 0) {
            if(year % 100 == 0) {
                if(year % 400 == 0) {
                    tmp = true;
                }
            } else {
                tmp = true;
            }
        }
        if(tmp == true) {
            System.out.println("Năm: " + year + " là năn nhuận");
        } else {
            System.out.println("Năm: " + year + " không phải là năn nhuận");
        }
    }
}
