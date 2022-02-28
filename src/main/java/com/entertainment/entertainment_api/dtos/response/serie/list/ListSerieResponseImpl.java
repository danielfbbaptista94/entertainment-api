package com.entertainment.entertainment_api.dtos.response.serie.list;

import com.entertainment.entertainment_api.domain.Serie;

import java.util.List;

public class ListSerieResponseImpl implements ListSerieResponse {
    private Integer quantidade;
    private List<Serie> series;

    @Override
    public Integer getQuantidade() {
        return quantidade;
    }

    @Override
    public List<Serie> getSeries() {
        return series;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setListSeries(List<Serie> series) {
        this.series = series;
    }
}
