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

        System.out.println("Delta của phương trình là: " + equation.getDiscriminant());
        System.out.println(equation.toString());
    }
}
