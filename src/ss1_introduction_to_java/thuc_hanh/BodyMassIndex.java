package ss1_introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class BodyMassIndex {
    public static void main(String[] args) {
        System.out.println("Tính chỉ số BMI của cơ thể!");
        Scanner sc = new Scanner(System.in);

        System.out.println("NHập chiều cao của cơ thể: ");
        double height = Double.parseDouble(sc.nextLine());

        System.out.println("NHập cân nặng của cơ thể: ");
        double weight = Double.parseDouble(sc.nextLine());

        double bmi = weight / Math.pow(height, 2);

        if (bmi < 18.5) {
            System.out.println("Underweight");
        } else if (bmi < 25.0) {
            System.out.println("Normal");
        } else if (bmi < 30.0) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }
    }
}
