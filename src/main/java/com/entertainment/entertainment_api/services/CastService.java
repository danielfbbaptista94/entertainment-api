package com.entertainment.entertainment_api.services;

import com.entertainment.entertainment_api.domain.Cast;
import com.entertainment.entertainment_api.domain.Movie;
import com.entertainment.entertainment_api.domain.Person;
import com.entertainment.entertainment_api.domain.Serie;
import com.entertainment.entertainment_api.dtos.requests.cast.assossiate_movie.AssossiateMovieRequestImpl;
import com.entertainment.entertainment_api.dtos.response.DefaultResponseImpl;
import com.entertainment.entertainment_api.repositories.ICastRepository;
import com.entertainment.entertainment_api.repositories.IMovieRepository;
import com.entertainment.entertainment_api.repositories.IPersonRepository;
import com.entertainment.entertainment_api.repositories.ISerieRepository;
import com.entertainment.entertainment_api.util.CalendarService;
import com.entertainment.entertainment_api.util.JsonService;
import com.entertainment.entertainment_api.util.StatusCode;
import com.entertainment.entertainment_api.util.exceptions.ApiException;
import com.entertainment.entertainment_api.util.exceptions.ExceptionMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class CastService {

    @Autowired
    private ICastRepository castRepository;

    @Autowired
    private IPersonRepository personRepository;

    @Autowired
    private IMovieRepository movieRepository;

    @Autowired
    private ISerieRepository serieRepository;

    @Autowired
    private CalendarService calendarService;

    @Autowired
    private JsonService jsonService;

    public DefaultResponseImpl inserir(AssossiateMovieRequestImpl body) {
        var cast = mapToCast(body);
        castRepository.save(cast);

        return mapToCreateResponse(StatusCode.CREATED);
    }

    private Cast mapToCast(AssossiateMovieRequestImpl body) {
        var person = getPerson(body.getPersonID());
        var movie = getMovie(body.getMovieID());

        return new Cast(
                body.getRole().trim().toUpperCase(Locale.ROOT),
                movie,
                person
        );
    }

    private Person getPerson(Long id) {
        var person = personRepository.findById(id);

        if (person.isPresent()) {
            return person.get();
        } else {
            throw new ApiException(ExceptionMessages.PERSON_NOT_FOUND.getMsgCorrelationId());
        }
    }

    private Movie getMovie(Long id) {
        var movie = movieRepository.findById(id);

        if (movie.isPresent()) {
            return movie.get();
        } else {
            throw new ApiException(ExceptionMessages.MOVIE_NOT_FOUND.getMsgCorrelationId());
        }
    }

    private Serie getSerie(Long id) {
        var serie = serieRepository.findById(id);

        if (serie.isPresent()) {
            return serie.get();
        } else {
            throw new ApiException(ExceptionMessages.SERIE_NOT_FOUND.getMsgCorrelationId());
        }
    }

    private DefaultResponseImpl mapToCreateResponse(StatusCode code){
        return new DefaultResponseImpl(code.getCode(), code.getDescription());
    }
}
