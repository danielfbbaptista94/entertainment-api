package com.entertainment.entertainment_api.resources.exceptions;

import com.entertainment.entertainment_api.util.JsonService;
import com.entertainment.entertainment_api.util.exceptions.ApiDefaultErro;
import com.entertainment.entertainment_api.util.exceptions.ApiErro;
import com.entertainment.entertainment_api.util.exceptions.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.entertainment.entertainment_api.util.exceptions.ExceptionMessages.*;

@ControllerAdvice
public class CustomResourceExceptionHandler {

    @Autowired
    private JsonService jsonService;

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiDefaultErro> customErrosHandler(ApiException exception) {
        var error = new ApiDefaultErro();

        if (exception.getMessage().equals(RUNTIME_ERRO.getMsgCorrelationId())) {
            var erroBody = new ApiErro(
                    RUNTIME_ERRO.getCode(), RUNTIME_ERRO.getSequential(),
                    RUNTIME_ERRO.getUserHelp(), RUNTIME_ERRO.getMessage(),
                    RUNTIME_ERRO.getMsgCorrelationId(), RUNTIME_ERRO.getCategory(),
                    RUNTIME_ERRO.getDeveloperMessage()
            );

            error.getErros().add(erroBody);
        }

        if (exception.getMessage().equals(MOVIE_NOT_FOUND.getMsgCorrelationId())) {
            var erroBody = new ApiErro(
                    MOVIE_NOT_FOUND.getCode(), MOVIE_NOT_FOUND.getSequential(),
                    MOVIE_NOT_FOUND.getUserHelp(), MOVIE_NOT_FOUND.getMessage(),
                    MOVIE_NOT_FOUND.getMsgCorrelationId(), MOVIE_NOT_FOUND.getCategory(),
                    MOVIE_NOT_FOUND.getDeveloperMessage()
            );

            error.getErros().add(erroBody);
        }

        if (exception.getMessage().equals(MOVIE_CONFLICT.getMsgCorrelationId())) {
            var erroBody = new ApiErro(
                    MOVIE_CONFLICT.getCode(), MOVIE_CONFLICT.getSequential(),
                    MOVIE_CONFLICT.getUserHelp(), MOVIE_CONFLICT.getMessage(),
                    MOVIE_CONFLICT.getMsgCorrelationId(), MOVIE_CONFLICT.getCategory(),
                    MOVIE_CONFLICT.getDeveloperMessage()
            );

            error.getErros().add(erroBody);
        }

        if (exception.getMessage().equals(DATE_CONVERSION_ERRO.getMsgCorrelationId())) {
            var erroBody = new ApiErro(
                    DATE_CONVERSION_ERRO.getCode(), DATE_CONVERSION_ERRO.getSequential(),
                    DATE_CONVERSION_ERRO.getUserHelp(), DATE_CONVERSION_ERRO.getMessage(),
                    DATE_CONVERSION_ERRO.getMsgCorrelationId(), DATE_CONVERSION_ERRO.getCategory(),
                    DATE_CONVERSION_ERRO.getDeveloperMessage()
            );

            error.getErros().add(erroBody);
        }


        return ResponseEntity.badRequest().body(error);
    }
}
