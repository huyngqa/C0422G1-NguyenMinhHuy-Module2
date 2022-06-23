package ss14_sort_algorithm.excercise;

import java.util.Arrays;

public class InsertSetting {
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int x = arr[i];
            int post = i;
            while (0 < post && x < arr[post - 1]) {
                arr[post] = arr[post - 1];
                post--;
            }
            arr[post] = x;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 5, -3, 7, -6, 12, 11};
        System.out.println("Trước khi sắp xếp: " + Arrays.toString(array));
        insertionSort(array);
        System.out.println("Sau khi sắp xếp: " + Arrays.toString(array));
    }
}
