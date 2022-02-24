package com.entertainment.entertainment_api.dtos.response;

public class DefaultResponseImpl implements DefaultResponse {
    private String statusCode;
    private String message;

    public DefaultResponseImpl() {
    }

    public DefaultResponseImpl(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
