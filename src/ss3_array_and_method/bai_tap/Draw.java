package ss3_array_and_method.bai_tap;

public class Draw {
    public static void main(String[] args) {
        for (int i = 1; i <=5 ; i++) {
            for (int j = 5-1; j >=i ; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <=i+(i-1); j++) {
                if(j==0 || j == i + (i-1) ) {
                    System.out.print(i);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (int i = 4; i >= 1; i--) {
            for (int j = 4; j >= i; j--) {
                System.out.print(" ");
            }
            for (int j = i + (i-1); j >=0 ; j--) {
                if(j==0 || j == i + (i-1)) {
                    System.out.print(i);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
