package ss2_loop_to_java.bai_tap;

public class PrimeLessThan100 {
    public static void main(String[] args) {
        int count;
        int number = 2;
        while (true) {
            count = 0;
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    count++;
                    break;
                }
            }
            if (count == 0) {
                System.out.println(number);
            }
            number++;
            if (number > 100) break;
        }
    }
}
