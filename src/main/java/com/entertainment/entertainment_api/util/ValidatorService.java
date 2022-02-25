package com.entertainment.entertainment_api.util;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

@Service
public class ValidatorService {
    private static Pattern DATE_PATTERN = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
    private static Pattern HOUR_PATTERN = Pattern.compile("^\\d{2}:\\d{2}:\\d{2}$");


    public boolean verificarNullEmptyBlank(String txt) {
        return txt == null || txt.isEmpty() || txt.isBlank();
    }

    public boolean verificarFormatoDate(String date) {
        return !DATE_PATTERN.matcher(date).matches();
    }

    public boolean verificarFormatoHora(String hour) {
        return !HOUR_PATTERN.matcher(hour).matches();
    }
}
