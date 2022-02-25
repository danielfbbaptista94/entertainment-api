package com.entertainment.entertainment_api.services;

import com.entertainment.entertainment_api.domain.Person;
import com.entertainment.entertainment_api.dtos.requests.person.create.CreatePersonRequestImpl;
import com.entertainment.entertainment_api.dtos.response.DefaultResponseImpl;
import com.entertainment.entertainment_api.dtos.response.person.list.ListPersonResponseImpl;
import com.entertainment.entertainment_api.repositories.IPersonRepository;
import com.entertainment.entertainment_api.util.CalendarService;
import com.entertainment.entertainment_api.util.JsonService;
import com.entertainment.entertainment_api.util.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class PersonService {

    @Autowired
    private IPersonRepository personRepository;

    @Autowired
    private CalendarService calendarService;

    @Autowired
    private JsonService jsonService;

    public DefaultResponseImpl inserir(CreatePersonRequestImpl body) {
        var movie = mapToPerson(body);
        personRepository.save(movie);

        return mapToCreateResponse(StatusCode.CREATED);
    }

    public ListPersonResponseImpl listAll() {
        var persons = personRepository.findAll();
        var response = new ListPersonResponseImpl();

        response.setListPerson(persons);
        response.setQuantidade(persons.size());

        return response;
    }

    private Person mapToPerson(CreatePersonRequestImpl body) {
        return new Person(
                body.getFirstName().trim().toUpperCase(Locale.ROOT),
                body.getLastName().trim().toUpperCase(Locale.ROOT),
                body.getBibliography().trim().toUpperCase(Locale.ROOT),
                calendarService.parseFormatterDate(body.getBirthday())
        );
    }

    private DefaultResponseImpl mapToCreateResponse(StatusCode code){
        return new DefaultResponseImpl(code.getCode(), code.getDescription());
    }
}
