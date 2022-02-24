package com.entertainment.entertainment_api.util;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Service
public class ValidatorService {
    public boolean verificarNullEmptyBlank(String txt) {
        return txt == null || txt.isEmpty() || txt.isBlank();
    }

    public boolean verificarFormatoDate(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate d = LocalDate.parse(date, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
