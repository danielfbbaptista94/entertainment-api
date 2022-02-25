package com.entertainment.entertainment_api.resources.person;

import com.entertainment.entertainment_api.domain.Person;
import com.entertainment.entertainment_api.dtos.requests.person.create.CreatePersonRequestImpl;
import com.entertainment.entertainment_api.dtos.response.DefaultResponseImpl;
import com.entertainment.entertainment_api.dtos.response.person.list.ListPersonResponseImpl;
import com.entertainment.entertainment_api.services.PersonService;
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
import java.util.List;

@Api(
        tags = "Persons Resources",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
)
@RestController
@CrossOrigin(origins = "*")
public class PersonResource {

    @Autowired
    private PersonService personService;

    @ApiOperation(
            value = "Create Person",
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
    @PostMapping(path = "/persons")
    public DefaultResponseImpl createMovie(@Valid @RequestBody CreatePersonRequestImpl body) {
        return personService.inserir(body);
    }

    @ApiOperation(
            value = "List Person",
            response = ListPersonResponseImpl.class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Requisição bem sucedida, retorna o status da requisição HTTP e uma mensagem de descrição",
                    response = ListPersonResponseImpl.class
            ),
            @ApiResponse(
                    code = 400,
                    message = "Requisição má sucedida.",
                    response = ApiErro.class
            )
    })
    @GetMapping(path = "/persons")
    public ResponseEntity<ListPersonResponseImpl> findAllMovies() {
        try {
            return new ResponseEntity<ListPersonResponseImpl>(personService.listAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<ListPersonResponseImpl>(HttpStatus.BAD_REQUEST);
        }
    }
}
