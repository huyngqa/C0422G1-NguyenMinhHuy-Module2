package external_exercises;

public class Abc {
    public static String solution(String str) {
        String result = "";
        for (int i = 0; i < str.length() - 1; i++) {
            result += str.charAt(i);
            if (str.charAt(i) < 123) {
                if(str.charAt(i + 1) < 91) {
                    result += " ";
                }
            }
        }
        result += str.charAt(str.length() - 1);
        return result.toLowerCase();
    }

    public static void main(String[] args) {
        System.out.println(solution("CodeGymDaNang"));
    }
}
