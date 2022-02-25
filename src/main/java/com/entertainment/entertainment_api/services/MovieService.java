package com.entertainment.entertainment_api.services;

import com.entertainment.entertainment_api.domain.Movie;
import com.entertainment.entertainment_api.dtos.requests.movie.create.CreateMovieRequestImpl;
import com.entertainment.entertainment_api.dtos.response.DefaultResponseImpl;
import com.entertainment.entertainment_api.dtos.response.movie.list.ListMovieResponseImpl;
import com.entertainment.entertainment_api.repositories.IMovieRepository;
import com.entertainment.entertainment_api.util.CalendarService;
import com.entertainment.entertainment_api.util.JsonService;
import com.entertainment.entertainment_api.util.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class MovieService {

    @Autowired
    private IMovieRepository movieRepository;

    @Autowired
    private CalendarService calendarService;

    @Autowired
    private JsonService jsonService;

    public DefaultResponseImpl inserir(CreateMovieRequestImpl body) {
        var movie = mapToMovie(body);
        movieRepository.save(movie);

        return mapToCreateResponse(StatusCode.CREATED);
    }

    public ListMovieResponseImpl listAll() {
        var movies = movieRepository.findAll();
        var response = new ListMovieResponseImpl();

        response.setListMovie(movies);
        response.setQuantidade(movies.size());

        return response;
    }

    private Movie mapToMovie(CreateMovieRequestImpl body) {
        return new Movie(
                body.getTitle().trim().toUpperCase(Locale.ROOT),
                body.getSinopse().trim().toUpperCase(Locale.ROOT),
                calendarService.parseFormatterHour(body.getDuration()),
                calendarService.parseFormatterDate(body.getReleaseDate())
        );
    }

    private DefaultResponseImpl mapToCreateResponse(StatusCode code){
        return new DefaultResponseImpl(code.getCode(), code.getDescription());
    }
}
