package ss11_dsa_stack_queue.excercise;

import java.util.Stack;

public class Binary {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int num = 10;
        do {
            stack.add(num % 2);
            num /= 2;
        } while (num != 0);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
