package fun.goodgoodstudy.bestpractice.urbanboot.urbanmanagement.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
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

    public static String format(Long epochMilliseconds) {
        return format(toEpochDateTime(epochMilliseconds));
    }

    public static LocalDateTime toEpochDateTime(Long epochMilliseconds) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(epochMilliseconds), ZoneId.of("UTC"));
    }

    public static String formattedUtcNow() {
        return format(utcNow());
    }

    public static LocalDateTime utcNow() {
        return LocalDateTime.now(ZoneOffset.UTC);
    }

    public static LocalDateTime parse(String dateTime) {
        return LocalDateTime.parse(dateTime, dateTimeFormatter);
    }
}
