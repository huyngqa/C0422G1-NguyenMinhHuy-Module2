package common;

public class CheckRegex {
    private static String REGEX_PERSON_ID = "^(NV|HV)-\\d{3}$";
    public static boolean checkRegexPersonId(String personId) {
        return personId.matches(REGEX_PERSON_ID);
    }
}
