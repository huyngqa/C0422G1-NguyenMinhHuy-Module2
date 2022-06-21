package ss11_dsa_stack_queue.excercise;

import java.util.HashMap;
import java.util.Map;

public class CountCharacter {
    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        String str = "nguyenminhhuy";
        map.put(str.charAt(0), 1);
        for (int i = 1; i < str.length(); i++) {
            if(map.containsKey(str.charAt(i))) {
                int count = map.get(str.charAt(i));
                map.put(str.charAt(i), ++count);
            } else {
                map.put(str.charAt(i),1);
            }
        }
        for (Map.Entry<Character, Integer> entrySet : map.entrySet()) {
            System.out.println("Kí tự: " + entrySet.getKey() + " xuất hiện: " + entrySet.getValue() + " lần.");
        }
    }
}
