package ss13_search_algorithm.excercise;

import java.util.*;

public class ConsecutiveString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        LinkedList<Character> linkedList = new LinkedList<>();
        List<Character> listMax = new ArrayList<>();
        linkedList.add(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if (linkedList.getLast() >= str.charAt(i) && linkedList.size() > 1) {
                linkedList.clear();
            }
            linkedList.add(str.charAt(i));
            if (linkedList.size() > listMax.size()) {
                listMax.clear();
                listMax.addAll(linkedList);
            }
        }
        for (Character character : listMax) {
            System.out.println(character);
        }
    }
}
