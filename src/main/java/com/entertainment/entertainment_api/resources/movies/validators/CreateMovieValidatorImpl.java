package com.entertainment.entertainment_api.resources.movies.validators;

import com.entertainment.entertainment_api.dtos.requests.movie.CreateMovieRequestImpl;
import com.entertainment.entertainment_api.util.JsonService;
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

    @Override
    public boolean isValid(CreateMovieRequestImpl requestBody, ConstraintValidatorContext constraintValidatorContext) {

        var sequential = 0;
        var badRequestCode = String.valueOf(HttpStatus.BAD_REQUEST.value());
        var message = "O campo obrigatório: ";
        List<ApiErro> errors = new ArrayList<>();

        if (requestBody.getTitle() == null) {
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
