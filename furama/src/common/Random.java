package common;

public class Random {
    public static String getRandom() {
        int n1 = (int) Math.floor(Math.random() * 10);
        int n2 = (int) Math.floor(Math.random() * 10);
        int n3 = (int) Math.floor(Math.random() * 10);
        int n4 = (int) Math.floor(Math.random() * 10);
        return "" + n1 + n2 + n3 + n4;
    }
    public static int randomPromotion() {
        int random = (int) Math.floor(Math.random() * 3) + 1;
        random *= 10;
        if(random == 30) {
            random = 50;
        }
        return random;
    }
}
