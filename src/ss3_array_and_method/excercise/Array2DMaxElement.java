package ss3_array_and_method.excercise;

import java.util.Scanner;

public class Array2DMaxElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số hàng của mảng: ");
        int row = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập số cột của mảng: ");
        int column = Integer.parseInt(scanner.nextLine());
        int[][] arrays = new int[row][column];

        System.out.println("Nhập các phần tử của mảng.");
        inputArray2D(arrays);

        System.out.println("Mảng bạn nhập là");
        outputArray2D(arrays);

        System.out.println("Giá trị lớn nhất trong mảng là: " + findMaxArray2D(arrays));
    }

    public static int findMaxArray2D(int[][] arrays) {
        int max = arrays[0][0];
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                if(arrays[i][j] > max) {
                    max = arrays[i][j];
                }
            }
        }
        return max;
    }

    public static void inputArray2D(int[][] arrays) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                System.out.printf("arr[%d][%d] = ", i, j);
                arrays[i][j] = Integer.parseInt(scanner.nextLine());
            }
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
