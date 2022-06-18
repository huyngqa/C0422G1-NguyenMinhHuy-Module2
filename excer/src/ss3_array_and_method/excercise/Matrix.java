package ss3_array_and_method.excercise;

import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số lượng phần tử: ");
        int size = Integer.parseInt(scanner.nextLine());
        int[][] arrays = new int[size][size];

        System.out.println("Nhập phần tử cho ma trận!");
        inputArray2D(arrays);

        System.out.println("Ma trận bạn vừa nhập là: ");
        outputArray2D(arrays);

        System.out.println("Tổng 2 đường chéo của ma trận là: " + sumDiagonalLineOfMatrix(arrays));
    }

    public static int sumDiagonalLineOfMatrix(int[][] arrays) {
        int sum = 0;
        for (int i = 0; i < arrays.length; i++) {
            sum += arrays[i][i] + arrays[i][arrays.length - i - 1];
        }
        return sum;
    }
    public static void inputArray2D(int[][] arrays) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                System.out.printf("arr[%d][%d] = ", i, j);
                arrays[i][j] = Integer.parseInt(scanner.nextLine());
            }
            System.out.println();
        }
    }

    public static void outputArray2D(int[][] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                System.out.printf("arr[%d][%d] = %d\t", i, j, arrays[i][j]);
            }
            System.out.println();
        }
    }
}
