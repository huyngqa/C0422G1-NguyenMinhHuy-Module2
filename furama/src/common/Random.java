package common;

public class Random {
    public static String getRandom() {
        int n1 = (int) Math.floor(Math.random() * 10);
        int n2 = (int) Math.floor(Math.random() * 10);
        int n3 = (int) Math.floor(Math.random() * 10);
        int n4 = (int) Math.floor(Math.random() * 10);
        return "" + n1 + n2 + n3 + n4;
    }
}
