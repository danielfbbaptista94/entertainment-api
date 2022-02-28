package com.entertainment.entertainment_api.dtos.requests.cast.assossiate_movie;

import io.swagger.annotations.ApiModelProperty;

public interface AssossiateMovieRequest {

    @ApiModelProperty(
            name = "Role.",
            example = "Role of the person on the movie",
            required = true
    )
    String getRole();

    @ApiModelProperty(
            name = "Person.",
            example = "Person in the",
            required = true
    )
    Long getPersonID();

    @ApiModelProperty(
            name = "Sinopse.",
            example = "Sinopse of the movie.",
            required = true
    )
    Long getMovieID();
}
