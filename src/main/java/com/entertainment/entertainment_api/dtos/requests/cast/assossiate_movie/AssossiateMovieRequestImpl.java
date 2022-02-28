package com.entertainment.entertainment_api.dtos.requests.cast.assossiate_movie;

import com.entertainment.entertainment_api.resources.cast.validator.AssossiateMovieValidator;

@AssossiateMovieValidator
public class AssossiateMovieRequestImpl implements AssossiateMovieRequest {
    private String role;
    private Long personID;
    private Long movieID;


    @Override
    public String getRole() {
        return role;
    }

    @Override
    public Long getPersonID() {
        return personID;
    }

    @Override
    public Long getMovieID() {
        return movieID;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPersonID(Long personID) {
        this.personID = personID;
    }

    public void setMovieID(Long movieID) {
        this.movieID = movieID;
    }
}
