package com.springboot.helpers;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class DateHelper {

    public static Date now() {
        return Date.from(OffsetDateTime.now(ZoneOffset.UTC).toInstant());
    }

    public static LocalDate date() {
        return LocalDate.now(ZoneOffset.UTC);
    }

    public static OffsetDateTime time() {
        return OffsetDateTime.now(ZoneOffset.UTC);
    }


    public static Date nowWithDays(long days) {
        return Date.from(OffsetDateTime.now(ZoneOffset.UTC).plusDays(days).toInstant());
    }

    public static long daysBetween(LocalDate startDate, LocalDate endDate) {
        return Duration.between(startDate.atTime(0, 0), endDate.atTime(0, 0)).toDays();
    }

    public static OffsetDateTime toOffsetDate(LocalDateTime localDate) {
        return OffsetDateTime.of(localDate, ZoneOffset.UTC);
    }

    public static Date nowInUtcStringFormat() {
        int offset = TimeZone.getDefault().getOffset(Date.from(Instant.now()).getTime());
        return Date.from(OffsetDateTime.now().toInstant().minusMillis(offset));
    }

    public static Date dateInUtcStringFormat(LocalDateTime localDateTime) {
        int offset = TimeZone.getDefault().getOffset(Date.from(Instant.now()).getTime());
        return Date.from(localDateTime.atOffset(ZoneOffset.UTC).toInstant().minusMillis(offset));
    }

    public static LocalDateTime toLocalUtcDate(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    public static String formatDate(LocalDateTime date) {
        return date.format(DateTimeFormatter.ofPattern("d-MMM-uuuu HH:mm:ss"));
    }
}
