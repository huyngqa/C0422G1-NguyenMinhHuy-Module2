package ss3_array_and_method.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class ElementArrayDelete {
    public static void main(String[] args) {
        int[] arrays = {10, 6, 3, 9, 4, 5, 0, 0};
        System.out.println("Mảng của bạn là: " + Arrays.toString(arrays));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập giá trị bạn muốn xoá: ");
        int value = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < arrays.length; i++) {
            if (value == arrays[i]) {
                for (int j = i; j < arrays.length - 1; j++) {
                    arrays[j] = arrays[j + 1];
                }
                arrays[arrays.length - 1] = 0;
            }
        }
        System.out.println("Mảng của bản sau khi xoá giá trị: " + value + " là: " + Arrays.toString(arrays));
    }
}
