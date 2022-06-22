package ss13_search_algorithm.excercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StringMaxLength {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        List<Character> listMax = new ArrayList<>();
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
            for (int j = i + 1; j < str.length(); j++) {
                if(list.getLast() < str.charAt(j)) {
                    list.add(str.charAt(j));
                }
            }
            if(list.size() > listMax.size()) {
                listMax.clear();
                listMax.addAll(list);
            }
            list.clear();
        }
        for (Character character : listMax) {
            System.out.println(character);
        }
    }
}
