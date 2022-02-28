package com.entertainment.entertainment_api.services;

import com.entertainment.entertainment_api.domain.Serie;
import com.entertainment.entertainment_api.dtos.requests.serie.create.CreateSerieRequestImpl;
import com.entertainment.entertainment_api.dtos.response.DefaultResponseImpl;
import com.entertainment.entertainment_api.dtos.response.serie.list.ListSerieResponseImpl;
import com.entertainment.entertainment_api.repositories.ISerieRepository;
import com.entertainment.entertainment_api.util.CalendarService;
import com.entertainment.entertainment_api.util.JsonService;
import com.entertainment.entertainment_api.util.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class SerieService {

    @Autowired
    private ISerieRepository serieRepository;

    @Autowired
    private CalendarService calendarService;

    @Autowired
    private JsonService jsonService;

    public DefaultResponseImpl inserir(CreateSerieRequestImpl body) {
        var serie = mapToSerie(body);
        serieRepository.save(serie);

        return mapToCreateResponse(StatusCode.CREATED);
    }

    public ListSerieResponseImpl listAll() {
        var series = serieRepository.findAll();
        var response = new ListSerieResponseImpl();

        response.setListSeries(series);
        response.setQuantidade(series.size());

        return response;
    }

    private Serie mapToSerie(CreateSerieRequestImpl body) {
        return new Serie(
                body.getTitle().trim().toUpperCase(Locale.ROOT),
                body.getSinopse().trim().toUpperCase(Locale.ROOT),
                calendarService.parseFormatterDate(body.getReleaseDate())
        );
    }

    private DefaultResponseImpl mapToCreateResponse(StatusCode code){
        return new DefaultResponseImpl(code.getCode(), code.getDescription());
    }
}
