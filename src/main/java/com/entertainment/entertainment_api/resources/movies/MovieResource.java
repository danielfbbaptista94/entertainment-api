package com.entertainment.entertainment_api.resources.movies;

import com.entertainment.entertainment_api.dtos.requests.movie.create.CreateMovieRequestImpl;
import com.entertainment.entertainment_api.dtos.response.DefaultResponseImpl;
import com.entertainment.entertainment_api.dtos.response.movie.list.ListMovieResponseImpl;
import com.entertainment.entertainment_api.services.MovieService;
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
    @PostMapping(path = "/movies")
    public DefaultResponseImpl createMovie(@Valid @RequestBody CreateMovieRequestImpl body) {
        return movieService.inserir(body);
    }

    @ApiOperation(
            value = "List Movie",
            response = ListMovieResponseImpl.class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Requisição bem sucedida, retorna o status da requisição HTTP e uma mensagem de descrição",
                    response = ListMovieResponseImpl.class
            ),
            @ApiResponse(
                    code = 400,
                    message = "Requisição má sucedida.",
                    response = ApiErro.class
            )
    })
    @GetMapping(path = "movies")
    public ResponseEntity<ListMovieResponseImpl> findAllMovies() {
        try {
            return new ResponseEntity<ListMovieResponseImpl>(movieService.listAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<ListMovieResponseImpl>(HttpStatus.BAD_REQUEST);
        }
    }
}
