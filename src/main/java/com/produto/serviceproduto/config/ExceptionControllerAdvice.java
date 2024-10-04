package com.produto.serviceproduto.config;

import com.produto.serviceproduto.data.response.ErroResponse;
import jakarta.persistence.NoResultException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.IllegalFormatFlagsException;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ResponseBody
    @ExceptionHandler(NoResultException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErroResponse NoResult(NoResultException e){
        return new ErroResponse("X_100", e.getMessage(), "TO DO");
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErroResponse InputIncorreto(MethodArgumentTypeMismatchException e){
        return new ErroResponse("X_200", "Formato do parametro inválido", "TO DO");
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErroResponse iNTERNALeRROR(Exception e){
        return new ErroResponse("X_300", e.getMessage(), "TO DO");
    }


}
