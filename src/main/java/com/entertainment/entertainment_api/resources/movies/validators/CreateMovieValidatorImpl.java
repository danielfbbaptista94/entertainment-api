package com.entertainment.entertainment_api.resources.movies.validators;

import com.entertainment.entertainment_api.dtos.requests.movie.create.CreateMovieRequestImpl;
import com.entertainment.entertainment_api.util.JsonService;
import com.entertainment.entertainment_api.util.ValidatorService;
import com.entertainment.entertainment_api.util.exceptions.ApiErro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class CreateMovieValidatorImpl
        implements ConstraintValidator<CreateMovieValidator, CreateMovieRequestImpl> {

    @Autowired
    private JsonService jsonService;

    @Autowired
    private ValidatorService validatorService;

    @Override
    public boolean isValid(CreateMovieRequestImpl requestBody, ConstraintValidatorContext constraintValidatorContext) {

        var sequential = 0;
        var badRequestCode = String.valueOf(HttpStatus.BAD_REQUEST.value());
        var message = "O campo obrigatório: ";
        List<ApiErro> errors = new ArrayList<>();

        if (validatorService.verificarNullEmptyBlank(requestBody.getTitle())) {
            errors.add(
                    new ApiErro.Builder(badRequestCode, message.concat("title"))
                            .userHelp("Os Vingadores")
                            .sequential(String.valueOf(++sequential))
                            .msgCorrelationId("title")
                            .category("MethodArgumentNotValidException")
                            .developerMessage("O campo da requisição é obrigatório.")
                            .build()
            );
        }

        if (validatorService.verificarNullEmptyBlank(requestBody.getSinopse())) {
            errors.add(
                    new ApiErro.Builder(badRequestCode, message.concat("sinopse"))
                            .userHelp("Descrição do filme")
                            .sequential(String.valueOf(++sequential))
                            .msgCorrelationId("sinopse")
                            .category("MethodArgumentNotValidException")
                            .developerMessage("O campo da requisição é obrigatório.")
                            .build()
            );
        }

        if (validatorService.verificarNullEmptyBlank(requestBody.getReleaseDate())) {
            errors.add(
                    new ApiErro.Builder(badRequestCode, message.concat("releaseDate"))
                            .userHelp("yyyy-MM-dd")
                            .sequential(String.valueOf(++sequential))
                            .msgCorrelationId("releaseDate")
                            .category("MethodArgumentNotValidException")
                            .developerMessage("O campo da requisição é obrigatório.")
                            .build()
            );
        } else if (validatorService.verificarFormatoDate(requestBody.getReleaseDate())) {
            errors.add(
                    new ApiErro.Builder(badRequestCode,
                            "Formato da data inválida.")
                            .userHelp("yyyy-MM-dd")
                            .sequential(String.valueOf(++sequential))
                            .msgCorrelationId("releaseDate")
                            .category("MethodArgumentNotValidException")
                            .developerMessage("Formato inválido.")
                            .build()
            );
        }

        if (validatorService.verificarNullEmptyBlank(requestBody.getDuration())) {
            errors.add(
                    new ApiErro.Builder(badRequestCode, message.concat("duration"))
                            .userHelp("yyyy-MM-dd")
                            .sequential(String.valueOf(++sequential))
                            .msgCorrelationId("duration")
                            .category("MethodArgumentNotValidException")
                            .developerMessage("O campo da requisição é obrigatório.")
                            .build()
            );
        } else if (validatorService.verificarFormatoHora(requestBody.getDuration())) {
            errors.add(
                    new ApiErro.Builder(badRequestCode,
                            "Formato da hora inválida.")
                            .userHelp("hh:mm:ss")
                            .sequential(String.valueOf(++sequential))
                            .msgCorrelationId("duration")
                            .category("MethodArgumentNotValidException")
                            .developerMessage("Formato inválido.")
                            .build()
            );
        }

        errors.forEach(erroMessage -> {
            var strObj = jsonService.stringify(erroMessage);

            constraintValidatorContext.disableDefaultConstraintViolation();

            constraintValidatorContext.buildConstraintViolationWithTemplate(strObj)
                    .addPropertyNode(erroMessage.getMsgCorrelationId())
                    .addConstraintViolation();
        });

        return errors.isEmpty();
    }
}
