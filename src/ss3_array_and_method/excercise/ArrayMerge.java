package ss3_array_and_method.excercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayMerge {
    public static void main(String[] args) {
        int[] arrays1 = new int[5];
        int[] arrays2 = new int[6];

        System.out.println("Nhập phần tử cho mảng thứ nhất");
        inputArray(arrays1);
        System.out.println("Mảng 1 là: " + Arrays.toString(arrays1));
        System.out.println();

        System.out.println("Nhập phần tử cho mảng thứ hai");
        inputArray(arrays2);
        System.out.println("Mảng 2 là: " + Arrays.toString(arrays2));
        System.out.println();

        int[] arrays3 = new int[arrays1.length + arrays2.length];
        for (int i = 0; i < arrays1.length; i++) {
            arrays3[i] = arrays1[i];
        }
        for (int i = 0; i < arrays2.length; i++) {
            arrays3[arrays1.length + i] = arrays2[i];
        }
        System.out.println("Mảng 3 sau khi gộp mảng 1 và mảng 2 là: " + Arrays.toString(arrays3));
    }

    public static void inputArray(int[] arrays) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arrays.length; i++) {
            System.out.print("NHập vào phần tử thứ " + i + ": ");
            arrays[i] = Integer.parseInt(scanner.nextLine());
        }
    }
}
