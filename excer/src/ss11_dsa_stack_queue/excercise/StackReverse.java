package ss11_dsa_stack_queue.excercise;

import java.util.Arrays;
import java.util.Stack;

public class StackReverse {
    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 8};
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
        System.out.println(Arrays.toString(arr));
    }
}
