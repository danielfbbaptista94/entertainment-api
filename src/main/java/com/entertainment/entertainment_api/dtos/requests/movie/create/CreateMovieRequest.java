package com.entertainment.entertainment_api.dtos.requests.movie.create;

import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

public interface CreateMovieRequest {

    @ApiModelProperty(
            name = "Title.",
            example = "Title of the movie",
            required = true
    )
    String getTitle();

    @ApiModelProperty(
            name = "Sinopse.",
            example = "Sinopse of the movie.",
            required = true
    )
    String getSinopse();

    @ApiModelProperty(
            name = "Release Date.",
            example = "Release Date of the movie.",
            required = true
    )
    String getReleaseDate();

    @ApiModelProperty(
            name = "Duration.",
            example = "Duration of the movie.",
            required = true
    )
    String getDuration();
}
