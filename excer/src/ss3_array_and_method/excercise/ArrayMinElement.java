package ss3_array_and_method.excercise;

import java.util.Scanner;

public class ArrayMinElement {
    public static void main(String[] args) {
        int[] arrays = new int[10];
        System.out.println("Nhập phần tử vào mảng");
        inputArray(arrays);

        System.out.println("Giá trị nhỏ nhất trong mảng là: " + findMinArray(arrays));
    }

    public static int findMinArray(int[] arrays) {
        int min = arrays[0];
        for (int i = 1; i < arrays.length; i++) {
            if (arrays[i] < min) {
                min = arrays[i];
            }
        }
        return min;
    }

    public static void inputArray(int[] arrays) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arrays.length; i++) {
            System.out.printf("arr[%d] = ", i);
            arrays[i] = Integer.parseInt(scanner.nextLine());
        }
    }
}
