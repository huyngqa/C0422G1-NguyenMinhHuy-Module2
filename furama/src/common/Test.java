package common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String day = "20-02-1999";
        LocalDate a = LocalDate.parse(day, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println(a);

    }
}
