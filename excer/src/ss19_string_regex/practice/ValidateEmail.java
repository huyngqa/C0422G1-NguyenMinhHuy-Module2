package ss19_string_regex.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateEmail {
    private static Pattern pattern;
    private Matcher matcher;

//    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+){1,2}$";
    private static final String EMAIL_REGEX = "^\\w+@+\\w+(\\.\\w+){1,2}$";

    public ValidateEmail() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }

    public boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] validEmail = new String[] { "a@gmail.com", "ab_12@yahoo.com.vn", "abc@hotmail.com" };
        String[] invalidEmail = new String[] { "@gmail.com", "ab@gmail.", "@#abc@gmail.com" };

        ValidateEmail validateEmail = new ValidateEmail();
        for (String email : validEmail) {
            System.out.println("Email: " + email + " is valid: " + validateEmail.validate(email));
        }
        for (String email : invalidEmail) {
            System.out.println("Email: " + email + " is valid: " + validateEmail.validate(email));
        }
    }
}
