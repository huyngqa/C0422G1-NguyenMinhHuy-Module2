package ss19_string_regex.excercise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePhone {
    public static void main(String[] args) {
        String phone = "+84935507495";
        String pattern = "^(\\+84|0)[0-9]{9}$";
        boolean check = phone.matches(pattern);
        String valid;
        if(check)
            valid = "hợp lệ";
        else
            valid = "không hợp lệ";
        System.out.println("Số điện thoại "+ valid);
    }
}
