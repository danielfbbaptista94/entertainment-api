package com.entertainment.entertainment_api.resources.cast;

import com.entertainment.entertainment_api.dtos.requests.cast.assossiate_movie.AssossiateMovieRequestImpl;
import com.entertainment.entertainment_api.dtos.response.DefaultResponseImpl;
import com.entertainment.entertainment_api.services.CastService;
import com.entertainment.entertainment_api.util.exceptions.ApiErro;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(
        tags = "Cast Resources",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
)
@RestController
@CrossOrigin(origins = "*")
public class CastResource {

    @Autowired
    private CastService castService;

    @ApiOperation(
            value = "Create Movie",
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
    @PostMapping(path = "/assossiate_movies")
    public DefaultResponseImpl createMovie(@Valid @RequestBody AssossiateMovieRequestImpl body) {
        return castService.inserir(body);
    }
}
