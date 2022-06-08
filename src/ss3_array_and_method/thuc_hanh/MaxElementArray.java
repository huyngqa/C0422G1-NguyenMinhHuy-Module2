package ss3_array_and_method.thuc_hanh;

import java.util.Scanner;

public class MaxElementArray {
    public static void main(String[] args) {
        System.out.println("Tìm tài sản lớn nhất của các tỉ phú");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập độ dài của mảng: ");
        int length = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.print("Nhập vào phần tử thứ " + i + ": ");
            arr[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Mảng của bạn là: ");
        for (int i = 0; i < length; i++) {
            System.out.printf("arr[%d] = %d\n", i , arr[i]);
        }
        int max = arr[0];
        for (int i = 1; i < length; i++) {
            if(max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println("Giá trị tài sản lớn nhất là: " + max);
    }
}
