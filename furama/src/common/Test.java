package common;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;


public class Test {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2022, 8, 6);//start
        LocalDate endDate = LocalDate.of(2022, 8, 16);//end
        LocalDate startDate1 = LocalDate.of(2022, 8, 8);//b.start
        LocalDate endDate1 = LocalDate.of(2022, 8, 15);//b.end


        System.out.println(DAYS.between(startDate,endDate));
//        System.out.println(DAYS.between(startDate,startDate1));
    }
}
