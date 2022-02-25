package com.entertainment.entertainment_api.dtos.requests.person.create;

import com.entertainment.entertainment_api.resources.person.validators.CreatePersonValidator;

@CreatePersonValidator
public class CreatePersonRequestImpl implements CreatePersonRequest {
    private String firstName;
    private String lastName;
    private String bibliography;
    private String birthday;

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getBibliography() {
        return bibliography;
    }

    @Override
    public String getBirthday() {
        return birthday;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBibliography(String bibliography) {
        this.bibliography = bibliography;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
