package ss2_loop_to_java.excercise;

public class TwentyPrime {
    public static void main(String[] args) {
        System.out.println("20 số nguyên tố đầu tiên");
        int count = 0;
        int number = 2;
        int tmp;
        while (count < 20) {
            tmp  = 0;
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if(number % i == 0) {
                    tmp++;
                    break;
                }
            }
            if(tmp == 0) {
                System.out.println(number);
                count++;
            }
            number++;
        }
    }
}
