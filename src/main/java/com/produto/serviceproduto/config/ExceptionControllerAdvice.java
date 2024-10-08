package com.produto.serviceproduto.config;

import com.produto.serviceproduto.data.response.ErroResponse;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.IllegalFormatFlagsException;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @Value("${springdoc.swagger-ui.path}")
    private String urlDocumentation;

    @ResponseBody
    @ExceptionHandler(NoResultException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErroResponse NoResult(NoResultException e){
        return new ErroResponse("X_100", e.getMessage(), urlDocumentation);
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErroResponse InputIncorreto(MethodArgumentTypeMismatchException e){
        return new ErroResponse("X_200", "Formato do parametro inválido", urlDocumentation);
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErroResponse MethodArgument(MethodArgumentNotValidException e){
        String mensagen = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getField()+ " "+ fieldError.getDefaultMessage())
                .collect(Collectors.joining());
        return new ErroResponse("X_200", mensagen, urlDocumentation);
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErroResponse iNTERNALeRROR(Exception e){
        return new ErroResponse("X_300", e.getMessage(), urlDocumentation);
    }


}
