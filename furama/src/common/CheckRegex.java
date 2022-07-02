package common;

public class CheckRegex {
    private final static String REGEX_FACILITY_ID = "^SV(VL|RO|HO)-(\\d){4}$";
    private final static String REGEX_FACILITY_NAME = "^[A-Z](\\w)*$";
    private final static String REGEX_PERSON_NAME = "^[A-Z][a-z]{0,6}(\\s[A-Z][a-z]{0,6}){0,4}$";

    public static boolean checkRegexFacilityId(String facilityId) {
        return facilityId.matches(REGEX_FACILITY_ID);
    }

    public static boolean checkRegexNameService(String nameService) {
        return nameService.matches(REGEX_FACILITY_NAME);
    }
    public static boolean checkRegexPersonName(String personName) {
        return personName.matches(REGEX_PERSON_NAME);
    }

    public static void main(String[] args) {
        System.out.println(checkRegexPersonName("Nguyen Minh"));
    }
}
