package com.entertainment.entertainment_api.dtos.response.movie.list;

import com.entertainment.entertainment_api.domain.Movie;

import java.util.List;

public class ListMovieResponseImpl implements ListMovieResponse {
    private Integer quantidade;
    private List<Movie> movies;

    @Override
    public Integer getQuantidade() {
        return quantidade;
    }

    @Override
    public List<Movie> getMovies() {
        return movies;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setListMovie(List<Movie> movies) {
        this.movies = movies;
    }
}
