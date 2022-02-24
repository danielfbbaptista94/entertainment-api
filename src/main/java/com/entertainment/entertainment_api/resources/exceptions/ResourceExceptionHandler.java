package com.entertainment.entertainment_api.resources.exceptions;

import com.entertainment.entertainment_api.util.JsonService;
import com.entertainment.entertainment_api.util.exceptions.ApiDefaultErro;
import com.entertainment.entertainment_api.util.exceptions.ApiErro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @Autowired
    private JsonService jsonService;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiDefaultErro> methodArgumentNotValidException(MethodArgumentNotValidException exception) {
        var error = new ApiDefaultErro();

        exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
            var msg = jsonService.parse(fieldError.getDefaultMessage(), ApiErro.class);
            error.addErro(msg);
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ApiDefaultErro> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
        var error = new ApiDefaultErro();

        var mensagemErro = new ApiErro.Builder(
                String.valueOf(HttpStatus.METHOD_NOT_ALLOWED.value()),
                "Método requisitado " + exception.getMethod() + " não suportado!"
        ).sequential("1")
                .userHelp("Métodos suportados: " + exception.getSupportedHttpMethods())
                .msgCorrelationId("httpMethod")
                .category("METHOD_NOT_ALLOWED")
                .developerMessage("Esse recurso está disponível via POST.")
                .build();


        error.getErros().add(mensagemErro);
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiDefaultErro> httpMessageNotReadableException(
            HttpMessageNotReadableException exception,
            HttpServletRequest request
    ) {
        var error = new ApiDefaultErro();

        var mensagemDeErro = new ApiErro.Builder(
                String.valueOf(HttpStatus.CONFLICT.value()),
                "Corpo da Requisição não legível."
        ).sequential("0")
                .userHelp("Consulte a documentação em {dominio}/swagger-ui.html.")
                .msgCorrelationId("HTTP_REQUEST")
                .category("CONFLICT")
                .developerMessage("O corpo da requisição não pode ser processado, verificar na documentação.")
                .build();

        error.getErros().add(mensagemDeErro);
        return ResponseEntity.badRequest().body(error);
    }
}
