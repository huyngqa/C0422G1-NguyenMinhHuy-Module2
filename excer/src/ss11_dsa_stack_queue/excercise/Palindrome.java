package ss11_dsa_stack_queue.excercise;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        boolean temp = true;
        String palindrome = "Able was I ere I saw Elba";
        palindrome = palindrome.toLowerCase();
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < palindrome.length(); i++) {
            queue.offer(palindrome.charAt(i));
            stack.add(palindrome.charAt(i));
        }
        String result = "";
        while (!queue.isEmpty()) {
            if(stack.pop() == queue.poll()) {
                temp = true;
            } else {
                temp = false;
                break;
            }
        }
        System.out.println(temp);
    }
}
