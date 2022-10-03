package external_exercises;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Abc {
    public static List<Integer> randomResult() {
        List<Integer> list = new ArrayList<>();
        list.add((int) (Math.floor(Math.random() * 6) + 1));
        list.add((int) (Math.floor(Math.random() * 6) + 1));
        list.add((int) (Math.floor(Math.random() * 6) + 1));
        return list;
    }

    public static void main(String[] args) {
        System.out.println(randomResult());
    }
}
