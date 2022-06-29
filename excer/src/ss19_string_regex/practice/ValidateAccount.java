package ss19_string_regex.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateAccount {
    static final String ACCOUNT_REGEX = "^[a-z0-9_]{6,}$";

    public ValidateAccount() {
    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(ACCOUNT_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] validAccount = new String[] { "123abc_", "_abc123", "______", "123456","abcdefgh" };
        String[] invalidAccount = new String[] { ".@", "12345", "1234_", "abcde" };

        ValidateAccount validateAccount = new ValidateAccount();
        for (String account : validAccount) {
            System.out.println("Account: " + account + " isvalid: " + validateAccount.validate(account));
        }
        for (String account : invalidAccount) {
            System.out.println("Account: " + account + " isvalid: " + validateAccount.validate(account));
        }
    }
}
