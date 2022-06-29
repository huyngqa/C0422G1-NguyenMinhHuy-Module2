package ss19_string_regex.excercise;

import java.util.Scanner;

public class ClassesValidate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên lớp học: ");
        String classes = scanner.nextLine();
        boolean check = classes.matches("^[ACP]+\\d{4}[GHIKLM]$");
        String valid;
        if (check)
            valid = "hợp lệ";
        else
            valid = "không hợp lệ";
        System.out.println("Tên lớp " + valid);
    }
}
