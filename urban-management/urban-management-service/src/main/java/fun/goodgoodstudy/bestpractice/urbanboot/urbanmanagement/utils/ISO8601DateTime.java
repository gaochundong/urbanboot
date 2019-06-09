package fun.goodgoodstudy.bestpractice.urbanboot.urbanmanagement.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public enum ISO8601DateTime {
    ;

    private static final String DATE_FORMAT_ISO8601_PATTERN = "yyyy-MM-dd'T'HH:mm:ss[.SSS'Z']";
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT_ISO8601_PATTERN);

    public static String getPattern() {
        return DATE_FORMAT_ISO8601_PATTERN;
    }

    public static DateTimeFormatter getFormatter() {
        return dateTimeFormatter;
    }

    public static String format(LocalDateTime dateTime) {
        return dateTimeFormatter.format(dateTime);
    }

    public static LocalDateTime parse(String dateTime) {
        return LocalDateTime.parse(dateTime, dateTimeFormatter);
    }
}
