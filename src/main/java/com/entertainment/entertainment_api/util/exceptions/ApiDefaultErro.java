package com.entertainment.entertainment_api.util.exceptions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ApiDefaultErro implements Serializable {
    private static final long serialVersionUID = 1L;

    private final List<ApiErro> erros = new ArrayList<>();

    public List<ApiErro> getErros() {
        return erros;
    }

    public void addErro(ApiErro error) {
        erros.add(error);
    }
}
