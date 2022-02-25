package com.entertainment.entertainment_api.util.exceptions;

import org.springframework.http.HttpStatus;

public enum ExceptionMessages {
    RUNTIME_ERRO(
            String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()),
            "O servidor encontrou alguma condição inesperada", "0",
            "Consultar a documentação em {dominio}/swagger-ui.html.",
            "INTERNAL_SERVER_ERROR",
            "RunTimeExeption",
            "O servidor encontrou um erro durante o tempo de execução da API. É necessário uma " +
                    "verificação do Stack Trace do erro para averiguar a condição ocorrida."
    ),

    MOVIE_NOT_FOUND(
            String.valueOf(HttpStatus.NOT_FOUND.value()),
            "Movie not found", "0",
            "Consultar a documentação em {dominio}/swagger-ui.html.",
            "NOT_FOUND",
            "RunTimeExeption",
            "A API não encontrou um recurso necessário para a execução. Verificar com o administrador " +
                    "de dados se o recurso exsite na base."
    ),

    MOVIE_CONFLICT(
            String.valueOf(HttpStatus.CONFLICT.value()),
            "Movie already in the system", "0",
            "Consultar a documentação em {dominio}/swagger-ui.html.",
            "MOVIE_CONFLICT",
            "RunTimeExeption",
            "A API encontrou um conflito nos recursos do banco de dados. Verificar com o administrador" +
                    "de dados o recurso desejado."
    ),

    DATE_CONVERSION_ERRO(
            String.valueOf(HttpStatus.BAD_REQUEST),
            "Failed to convert date.", "0",
            "Consultar a documentação em {dominio}/swagger-ui.html.",
            "DATE_CONVERSION_ERRO",
            "RunTimeExeption",
            "A API não encontrou um recurso necessário para a execução. Verificar com o administrador " +
                    "de dados se o recurso exsite na base."
    ),

    HOUR_CONVERSION_ERRO(
            String.valueOf(HttpStatus.BAD_REQUEST),
            "Failed to convert hour.", "0",
            "Consultar a documentação em {dominio}/swagger-ui.html.",
            "HOUR_CONVERSION_ERRO",
            "RunTimeExeption",
            "A API não encontrou um recurso necessário para a execução. Verificar com o administrador " +
                    "de dados se o recurso exsite na base."
    );


    String code;
    String message;
    String sequential;
    String userHelp;
    String msgCorrelationId;
    String category;
    String developerMessage;

    ExceptionMessages(String code, String message, String sequential, String userHelp,
                      String msgCorrelationId, String category, String developerMessage) {
        this.code = code;
        this.message = message;
        this.sequential = sequential;
        this.userHelp = userHelp;
        this.msgCorrelationId = msgCorrelationId;
        this.category = category;
        this.developerMessage = developerMessage;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getSequential() {
        return sequential;
    }

    public String getUserHelp() {
        return userHelp;
    }

    public String getMsgCorrelationId() {
        return msgCorrelationId;
    }

    public String getCategory() {
        return category;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }
}
