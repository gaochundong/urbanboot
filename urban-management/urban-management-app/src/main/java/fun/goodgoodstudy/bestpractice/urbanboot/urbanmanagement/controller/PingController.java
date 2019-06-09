package fun.goodgoodstudy.bestpractice.urbanboot.urbanmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
public class PingController {
    private static final String DATE_FORMAT_ISO8601_PATTERN = "yyyy-MM-dd'T'HH:mm:ss[.SSS'Z']";
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT_ISO8601_PATTERN);

    @GetMapping(path = "/", produces = {"text/plain"})
    public String root() {
        return "Hello";
    }

    @GetMapping(path = "/ping", produces = {"text/plain"})
    public String ping() {
        return LocalDateTime.now(ZoneOffset.UTC).format(dateTimeFormatter);
    }

    @GetMapping(path = "/health", produces = {"text/plain"})
    public String health() {
        return "OK";
    }
}