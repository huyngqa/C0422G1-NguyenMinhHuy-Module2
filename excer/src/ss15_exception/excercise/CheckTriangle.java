package ss15_exception.excercise;

import java.util.Scanner;

public class CheckTriangle {
    private static void checkTriangle(int a, int b, int c) throws IllegalTriangleException {
        boolean checkTriangle = (a + b <= c) || (a + c <= b) || (c + b <= a);
        if (a < 0 || b < 0 || c < 0) {
            throw new IllegalTriangleException("Cạnh bạn nhập là số âm");
        } else if (checkTriangle) {
            throw new IllegalTriangleException("Ba cạnh bạn nhập không phải là cạnh tam giác");
        } else {
            System.out.println("Bạn nhập đúng");
        }
    }

    public static void main(String[] args) throws IllegalTriangleException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập cạnh a: ");
        int a = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập cạnh b: ");
        int b = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập cạnh c: ");
        int c = Integer.parseInt(scanner.nextLine());
        try {
            checkTriangle(a, b, c);
            System.out.println("Cạnh a: " + a);
            System.out.println("Cạnh b: " + b);
            System.out.println("Cạnh c: " + c);
        } catch (IllegalTriangleException triangleException) {
            System.out.println(triangleException.getMessage());
        }
    }
}
