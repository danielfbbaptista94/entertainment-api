package com.entertainment.entertainment_api.resources.series;

import com.entertainment.entertainment_api.dtos.requests.serie.create.CreateSerieRequestImpl;
import com.entertainment.entertainment_api.dtos.response.DefaultResponseImpl;
import com.entertainment.entertainment_api.dtos.response.serie.list.ListSerieResponseImpl;
import com.entertainment.entertainment_api.services.SerieService;
import com.entertainment.entertainment_api.util.exceptions.ApiErro;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(
        tags = "Serie Resources",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
)
@RestController
@CrossOrigin(origins = "*")
public class SerieResource {

    @Autowired
    private SerieService serieService;

    @ApiOperation(
            value = "Create Serie",
            response = DefaultResponseImpl.class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Requisição bem sucedida, retorna o status da requisição HTTP e uma mensagem de descrição",
                    response = DefaultResponseImpl.class
            ),
            @ApiResponse(
                    code = 400,
                    message = "Requisição má sucedida.",
                    response = ApiErro.class
            )
    })
    @PostMapping(path = "/series")
    public DefaultResponseImpl createSerie(@Valid @RequestBody CreateSerieRequestImpl body) {
        return serieService.inserir(body);
    }

    @ApiOperation(
            value = "List Series",
            response = ListSerieResponseImpl.class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Requisição bem sucedida, retorna o status da requisição HTTP e uma mensagem de descrição",
                    response = ListSerieResponseImpl.class
            ),
            @ApiResponse(
                    code = 400,
                    message = "Requisição má sucedida.",
                    response = ApiErro.class
            )
    })
    @GetMapping(path = "/series")
    public ResponseEntity<ListSerieResponseImpl> findAllSeries() {
        try {
            return new ResponseEntity<ListSerieResponseImpl>(serieService.listAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<ListSerieResponseImpl>(HttpStatus.BAD_REQUEST);
        }
    }
}
