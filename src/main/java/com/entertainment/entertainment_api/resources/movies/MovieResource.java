package com.entertainment.entertainment_api.resources.movies;

import com.entertainment.entertainment_api.dtos.requests.movie.CreateMovieRequestImpl;
import com.entertainment.entertainment_api.dtos.response.DefaultResponseImpl;
import com.entertainment.entertainment_api.services.MovieService;
import com.entertainment.entertainment_api.util.exceptions.ApiErro;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.entertainment.entertainment_api.util.exceptions.ExceptionMessages.RUNTIME_ERRO;

import javax.validation.Valid;

@Api(
        tags = "Movies Resources",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
)
@RestController
@CrossOrigin(origins = "*")
public class MovieResource {

    @Autowired
    private MovieService movieService;

    @ApiOperation(
            value = "Creat Movie",
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
                    message = "Requisição má sucedida, o validador de CPF determinou que o Assciado não está apto para " +
                            "executar um voto. | A seção de votação teve seu tempo expirado." +
                            "| O Associado não pode votar mais de uma vez",
                    response = ApiErro.class
            )
    })
    @PostMapping(path = "/createMovie")
    public DefaultResponseImpl createMovie(@Valid @RequestBody CreateMovieRequestImpl body) {
        return movieService.inserir(body);
    }
}
