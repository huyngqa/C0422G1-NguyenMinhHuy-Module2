package common;

public class CheckRegex {
    private final static String REGEX_FACILITY_ID = "^SV(VL|RO|HO)-(\\d){4}$";

    public static boolean checkRegexFacilityId(String facilityId) {
        return facilityId.matches(REGEX_FACILITY_ID);
    }
}
