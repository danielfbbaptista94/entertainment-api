package com.entertainment.entertainment_api.dtos.requests.movie;

import com.entertainment.entertainment_api.resources.movies.validators.CreateMovieValidator;

import java.time.LocalDate;

@CreateMovieValidator
public class CreateMovieRequestImpl implements CreateMovieRequest {
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

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
