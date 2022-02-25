package com.entertainment.entertainment_api.resources.person.validators;

import com.entertainment.entertainment_api.dtos.requests.person.create.CreatePersonRequestImpl;
import com.entertainment.entertainment_api.util.JsonService;
import com.entertainment.entertainment_api.util.ValidatorService;
import com.entertainment.entertainment_api.util.exceptions.ApiErro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class CreatePersonValidatorImpl
        implements ConstraintValidator<CreatePersonValidator, CreatePersonRequestImpl> {

    @Autowired
    private JsonService jsonService;

    @Autowired
    private ValidatorService validatorService;

    @Override
    public boolean isValid(CreatePersonRequestImpl requestBody, ConstraintValidatorContext constraintValidatorContext) {

        var sequential = 0;
        var badRequestCode = String.valueOf(HttpStatus.BAD_REQUEST.value());
        var message = "O campo obrigatório: ";
        List<ApiErro> errors = new ArrayList<>();

        if (validatorService.verificarNullEmptyBlank(requestBody.getFirstName())) {
            errors.add(
                    new ApiErro.Builder(badRequestCode, message.concat("firstName"))
                            .userHelp("Mc")
                            .sequential(String.valueOf(++sequential))
                            .msgCorrelationId("firstName")
                            .category("MethodArgumentNotValidException")
                            .developerMessage("O campo da requisição é obrigatório.")
                            .build()
            );
        }

        if (validatorService.verificarNullEmptyBlank(requestBody.getLastName())) {
            errors.add(
                    new ApiErro.Builder(badRequestCode, message.concat("lastName"))
                            .userHelp("Burguer")
                            .sequential(String.valueOf(++sequential))
                            .msgCorrelationId("lastName")
                            .category("MethodArgumentNotValidException")
                            .developerMessage("O campo da requisição é obrigatório.")
                            .build()
            );
        }

        if (validatorService.verificarNullEmptyBlank(requestBody.getBibliography())) {
            errors.add(
                    new ApiErro.Builder(badRequestCode, message.concat("bibliography"))
                            .userHelp("Write about the person, works, etc")
                            .sequential(String.valueOf(++sequential))
                            .msgCorrelationId("bibliography")
                            .category("MethodArgumentNotValidException")
                            .developerMessage("O campo da requisição é obrigatório.")
                            .build()
            );
        }

        if (validatorService.verificarNullEmptyBlank(requestBody.getBirthday())) {
            errors.add(
                    new ApiErro.Builder(badRequestCode, message.concat("birthday"))
                            .userHelp("yyyy-MM-dd")
                            .sequential(String.valueOf(++sequential))
                            .msgCorrelationId("birthday")
                            .category("MethodArgumentNotValidException")
                            .developerMessage("O campo da requisição é obrigatório.")
                            .build()
            );
        } else if (validatorService.verificarFormatoDate(requestBody.getBirthday())) {
            errors.add(
                    new ApiErro.Builder(badRequestCode,
                            "Formato da data inválida.")
                            .userHelp("yyyy-MM-dd")
                            .sequential(String.valueOf(++sequential))
                            .msgCorrelationId("birthday")
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
