package ss3_array_and_method.practice;

import java.util.Scanner;

public class ElementOfArray {
    public static void main(String[] args) {
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a name’s student: ");
        String input_name = scanner.nextLine();
        boolean tmp = false;
        for (int i = 0; i < students.length; i++) {
            if(students[i].equals(input_name)) {
                System.out.println("Tên của học sinh bạn nhập vào là " + input_name
                        + " nằm ở vị trí thứ: " + i);
                tmp = true;
            }
        }
        if(!tmp) {
            System.out.println("Tên bạn nhập không có trong danh sách");
        }
    }
}
