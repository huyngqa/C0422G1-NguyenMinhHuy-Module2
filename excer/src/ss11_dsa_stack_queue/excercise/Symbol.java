package ss11_dsa_stack_queue.excercise;

import java.util.Stack;

public class Symbol {
    final static char SYM_LEFT = '(';
    final static char SYM_RIGHT = ')';
    static Stack<Character> bStack = new Stack<>();
    public static void main(String[] args) {
        System.out.println(checkSymbol("s * )(s – a)( * (s – b) * (s – c)"));
    }
    public static boolean checkSymbol(String str) {
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == SYM_LEFT) {
                bStack.push(str.charAt(i));
            }
            else if(str.charAt(i) == SYM_RIGHT) {
                if(bStack.isEmpty()) {
                    return false;
                } else {
                      bStack.pop();
                }
            }
        }
        if(bStack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
