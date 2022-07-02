package common;

import java.time.LocalDate;
import java.time.Period;

public class CheckException {
    public static void checkDateOfBirth(LocalDate dateOfBirth) throws UserException {
        LocalDate now = LocalDate.now();
        boolean checkAge = Period.between(now, dateOfBirth).getYears() < 18
                || Period.between(now, dateOfBirth).getYears() > 100;
        if (checkAge) {
            throw new UserException("Tuổi bạn phải từ 18-100!");
        }
    }

    public static void checkDateEndBooking(LocalDate startDay, LocalDate endDay) throws UserException {
        boolean checkEndDay = Period.between(startDay, endDay).getDays() < 0;
        if (checkEndDay) {
            throw new UserException("Ngày kết thúc không được trước ngày bắt đầu");
        }
    }

    public static void checkDateStartBooking(LocalDate startDay) throws UserException {
        LocalDate now = LocalDate.now();
        boolean checkStartDay = Period.between(now, startDay).getDays() < 0;
        if (checkStartDay) {
            throw new UserException("Ngày bắt đầu không được trước ngày hiện tại");
        }
    }

    public static void checkArea(double area) throws UserException {
        if (area <= 30) {
            throw new UserException("Diện tích phải lớn hơn 30m2");
        }
    }

    public static void checkInteger(int number) throws UserException {
        if (number <= 0) {
            throw new UserException("Bạn vui lòng nhập số nguyên dương");
        }
    }

    public static void checkMaxOfPeople(int numOfPeople) throws UserException {
        if (numOfPeople < 1 || numOfPeople > 20) {
            throw new UserException("Số người từ 1->20");
        }
    }
}
