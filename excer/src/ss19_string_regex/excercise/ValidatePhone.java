package ss19_string_regex.excercise;

public class ValidatePhone {
    public static void main(String[] args) {
        String phone = "(84)-(0935507495)";
        String pattern ="\\(84\\)-\\(0\\d{9}\\)";
        boolean check = phone.matches(pattern);
        String valid;
        if(check)
            valid = "hợp lệ";
        else
            valid = "không hợp lệ";
        System.out.println("Số điện thoại "+ valid);
    }
}
