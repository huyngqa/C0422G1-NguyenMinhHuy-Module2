package external_exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if(s.equals("")) {
            System.out.println("123123123");
        }
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

