package ss3_array_and_method.thuc_hanh;

import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        System.out.println("Đảo ngược mảng");
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào độ dài của mảng: ");
        int length = Integer.parseInt(sc.nextLine());

        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.printf("Nhập vào phần tử thứ %d:  ", i);
            arr[i] = Integer.parseInt(sc.nextLine());
        }
        System.out.println("Mảng bạn nhập là:");
        for (int i = 0; i < length; i++) {
            System.out.printf("arr[%d] = %d\n" , i, arr[i]);
        }
        for (int i = 0; i < length / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[length - i - 1];
            arr[length - i - 1] = tmp;
        }
        System.out.println("Mảng sau khi đảo là:");
        for (int i = 0; i < length; i++) {
            System.out.printf("arr[%d] = %d\n" , i, arr[i]);
        }
    }
}
