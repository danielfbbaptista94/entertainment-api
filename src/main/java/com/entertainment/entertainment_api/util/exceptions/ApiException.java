package com.entertainment.entertainment_api.util.exceptions;

public class ApiException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ApiException(String mensagem) {
        super(mensagem);
    }

    public ApiException(String mensagem, Throwable causa) { super(mensagem, causa); }
}
