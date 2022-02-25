package com.entertainment.entertainment_api.dtos.response.person.list;

import com.entertainment.entertainment_api.domain.Person;

import java.util.List;

public class ListPersonResponseImpl implements ListPersonResponse {
    private Integer quantidade;
    private List<Person> persons;

    @Override
    public Integer getQuantidade() {
        return quantidade;
    }

    @Override
    public List<Person> getPersons() {
        return persons;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setListPerson(List<Person> persons) {
        this.persons = persons;
    }
}
