package com.entertainment.entertainment_api.dtos.requests.serie.create;

import com.entertainment.entertainment_api.resources.series.validators.CreateSerieValidator;

@CreateSerieValidator
public class CreateSerieRequestImpl implements CreateSerieRequest {
    private String title;
    private String sinopse;
    private String releaseDate;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getSinopse() {
        return sinopse;
    }

    @Override
    public String getReleaseDate() {
        return releaseDate;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public void setReleaseDate(String releaseDate) { this.releaseDate = releaseDate; }
}
