package ss3_array_and_method.practice;

import java.util.Scanner;

public class Student {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        do {
            System.out.print("Nhập số lượng điểm: ");
            size = Integer.parseInt(scanner.nextLine());
            if (size > 30)
                System.out.println("Độ dài không được vượt quá 30");
        } while (size > 30);
        int[] arrays = new int[size];
        System.out.println("Nhập điểm học sinh");
        inputArray(arrays);

        System.out.println("Số lượng học sinh đạt là: " + countStudentPass(arrays));
    }

    public static void inputArray(int[] arrays) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arrays.length; i++) {
            System.out.printf("Nhập điểm của học sinh thứ %d: ", (i + 1));
            arrays[i] = Integer.parseInt(scanner.nextLine());
        }
    }

    public static int countStudentPass(int[] arrays) {
        int count = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] >= 5) {
                count++;
            }
        }
        return count;
    }
}
