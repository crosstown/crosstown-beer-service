package net.fernandosimon.crosstownbeerservice.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author developer
 * @date 2019-08-23
 * @time 21:01
 */
@ControllerAdvice
public class MvcExceptionHandler {

    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException ex) {
        List<String> errorList = new ArrayList<>(ex.getConstraintViolations().size());

        ex.getConstraintViolations().forEach(error -> errorList.add(error.toString()));

        return new ResponseEntity<>(errorList, HttpStatus.ACCEPTED.BAD_REQUEST);

    }
}
