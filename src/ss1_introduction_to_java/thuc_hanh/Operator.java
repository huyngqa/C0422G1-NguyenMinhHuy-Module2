package ss1_introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class Operator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter width: ");
        float width = Float.parseFloat(sc.nextLine());
        System.out.println("Enter height: ");
        float height = Float.parseFloat(sc.nextLine());

        float area = width * height;
        System.out.println("Area is: " + area);
    }
}
