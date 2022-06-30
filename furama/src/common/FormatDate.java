package common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormatDate {
    public static String getDateFormatted(LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY");
        return localDate.format(formatter);
    }
}
