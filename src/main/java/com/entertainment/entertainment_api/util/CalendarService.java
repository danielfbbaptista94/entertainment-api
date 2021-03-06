package com.entertainment.entertainment_api.util;

import com.entertainment.entertainment_api.util.exceptions.ApiException;
import com.entertainment.entertainment_api.util.exceptions.ExceptionMessages;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class CalendarService {
    public LocalDate parseFormatterDate(String dateString) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(dateString, formatter);
        } catch (DateTimeException exception) {
            throw new ApiException(ExceptionMessages.DATE_CONVERSION_ERRO.getMsgCorrelationId());
        }
    }

    public LocalTime parseFormatterHour(String hourString) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            return LocalTime.parse(hourString, formatter);
        } catch (DateTimeException exception) {
            throw new ApiException(ExceptionMessages.HOUR_CONVERSION_ERRO.getMsgCorrelationId());
        }
    }
}
