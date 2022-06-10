package ss4_class_object_to_java.exercise.quadratic_equation;

import java.util.Scanner;

public class MainQuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào giá trị a: ");
        double a = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập vào giá trị b: ");
        double b = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập vào giá trị c: ");
        double c = Double.parseDouble(scanner.nextLine());

        QuadraticEquation equation = new QuadraticEquation(a, b, c);
        double delta = equation.getDiscriminant();
        System.out.println("Delta của phương trình là: " + delta);
        if (delta > 0) {
            System.out.println("Phương trình có hai nghiệm: x1 = " + equation.getRoot1()
                    + ", x2 = " + equation.getRoot2());
        } else if(delta == 0) {
            System.out.println("Phương trình có 1 nghiệm x1 = x2 = " + equation.getRoot1());
        } else {
            System.out.println("Phương trình vô nghiệm");
        }

    }
}
