package ss14_sort_algorithm.excercise;

import java.util.Arrays;

public class InsertSort {
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int x = arr[i];
            int post = i;
            System.out.println("Lần chèn thứ: " + i);
            System.out.println(x);
            while (0 < post && x < arr[post - 1]) {
                arr[post] = arr[post - 1];
                post--;
                System.out.println(Arrays.toString(arr));
            }
            arr[post] = x;
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 5, -3, 5, -6, 12, 5};
        System.out.println("Trước khi sắp xếp: " + Arrays.toString(array));
        insertSort(array);
        System.out.println("Sau khi sắp xếp: " + Arrays.toString(array));
    }
}
