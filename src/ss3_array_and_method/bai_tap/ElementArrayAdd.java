package ss3_array_and_method.bai_tap;


import java.util.Arrays;
import java.util.Scanner;

public class ElementArrayAdd {
    public static void main(String[] args) {
        int[] arrays = {10, 4, 6, 5, 8, 2, 3, 0, 0, 0};
        System.out.println("Mảng của bạn là: " + Arrays.toString(arrays));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập giá trị bạn muốn thêm vào mảng: ");
        int value = Integer.parseInt(scanner.nextLine());
        System.out.print("Ví trí bạn muốn thêm vào: ");
        int index = Integer.parseInt(scanner.nextLine());

        for (int i = arrays.length - 1; i >= 0; i--) {

            for (int j = arrays.length - 1; j > index; j--) {
                arrays[j] = arrays[j - 1];
            }
            arrays[index] = value;
            break;
        }
        System.out.println("Mảng sau khi thêm giá trị: " + value + " vào vị trí thứ: " + index
                + " là: " + Arrays.toString(arrays));
    }
}
