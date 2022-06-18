package external_exercises;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3};
        System.out.println(solution(arr));
    }
    public static boolean solution(int[] arr) {
        int a = arr[0];
        int b = arr[arr.length - 1];
        int j = arr.length - 2;
        for (int i = 1; i <= j; ) {
            if ((i == j) && (a == b)) {
                return true;
            } else {
                if (a < b) {
                    a = a + arr[i];
                    i++;

                } else {
                    b = b + arr[j];
                    j--;

                }
            }
        }
        return false;
    }
}

