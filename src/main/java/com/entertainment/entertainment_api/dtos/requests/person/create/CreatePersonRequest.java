package com.entertainment.entertainment_api.dtos.requests.person.create;

import io.swagger.annotations.ApiModelProperty;

public interface CreatePersonRequest {

    @ApiModelProperty(
            name = "First Name.",
            example = "Daniel",
            required = true
    )
    String getFirstName();

    @ApiModelProperty(
            name = "Last Name.",
            example = "Baptista",
            required = true
    )
    String getLastName();

    @ApiModelProperty(
            name = "Bibliography.",
            example = "Bibliography of the person",
            required = true
    )
    String getBibliography();

    @ApiModelProperty(
            name = "Birthday.",
            example = "Birthday of the person.",
            required = true
    )
    String getBirthday();
}
