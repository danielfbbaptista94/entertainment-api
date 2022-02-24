package com.entertainment.entertainment_api.dtos.requests.movie.create;

import com.entertainment.entertainment_api.resources.movies.validators.CreateMovieValidator;

@CreateMovieValidator
public class CreateMovieRequestImpl implements CreateMovieRequest {
    private String title;
    private String sinopse;
    private String releaseDate;
    private String duration;


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

    @Override
    public String getDuration() {
        return duration;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public void setReleaseDate(String releaseDate) { this.releaseDate = releaseDate; }

    public void setDuration(String duration) { this.duration = duration; }
}
