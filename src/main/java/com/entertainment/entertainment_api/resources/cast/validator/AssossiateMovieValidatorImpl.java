package com.entertainment.entertainment_api.resources.cast.validator;

import com.entertainment.entertainment_api.dtos.requests.cast.assossiate_movie.AssossiateMovieRequestImpl;
import com.entertainment.entertainment_api.util.JsonService;
import com.entertainment.entertainment_api.util.ValidatorService;
import com.entertainment.entertainment_api.util.exceptions.ApiErro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class AssossiateMovieValidatorImpl
        implements ConstraintValidator<AssossiateMovieValidator, AssossiateMovieRequestImpl> {

    @Autowired
    private JsonService jsonService;

    @Autowired
    private ValidatorService validatorService;

    @Override
    public boolean isValid(AssossiateMovieRequestImpl requestBody, ConstraintValidatorContext constraintValidatorContext) {

        var sequential = 0;
        var badRequestCode = String.valueOf(HttpStatus.BAD_REQUEST.value());
        var message = "O campo obrigatório: ";
        List<ApiErro> errors = new ArrayList<>();

        if (validatorService.verificarNullEmptyBlank(requestBody.getRole())) {
            errors.add(
                    new ApiErro.Builder(badRequestCode, message.concat("role"))
                            .userHelp("Os Vingadores")
                            .sequential(String.valueOf(++sequential))
                            .msgCorrelationId("role")
                            .category("MethodArgumentNotValidException")
                            .developerMessage("O campo da requisição é obrigatório.")
                            .build()
            );
        }

        if (requestBody.getPersonID() < 1) {
            errors.add(
                    new ApiErro.Builder(badRequestCode, message.concat("personID"))
                            .userHelp("Ex: 1")
                            .sequential(String.valueOf(++sequential))
                            .msgCorrelationId("personID")
                            .category("MethodArgumentNotValidException")
                            .developerMessage("O campo da requisição é obrigatório.")
                            .build()
            );
        }

        if (requestBody.getMovieID() < 1) {
            errors.add(
                    new ApiErro.Builder(badRequestCode, message.concat("movieID"))
                            .userHelp("Ex: 1")
                            .sequential(String.valueOf(++sequential))
                            .msgCorrelationId("movieID")
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
