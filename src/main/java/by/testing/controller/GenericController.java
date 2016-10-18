package by.testing.controller;

import by.testing.dto.JsonExceptionMessage;
import javassist.NotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Анастасия on 06.09.2016.
 */
public abstract class GenericController<S> {

    private static final String ERROR_MESSAGE_TITLE = "Error";

    protected S service;

    protected GenericController(S service) {
        this.service = service;
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public JsonExceptionMessage handleException(NullPointerException ex) {
        return new JsonExceptionMessage(ERROR_MESSAGE_TITLE, ex.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public JsonExceptionMessage handleException(NotFoundException ex) {
        return new JsonExceptionMessage(ERROR_MESSAGE_TITLE, ex.getMessage());
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public JsonExceptionMessage handleException(AccessDeniedException ex) {
        return new JsonExceptionMessage(ERROR_MESSAGE_TITLE, ex.getMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public JsonExceptionMessage handleException(DataIntegrityViolationException ex) {
        return new JsonExceptionMessage(ERROR_MESSAGE_TITLE, ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public JsonExceptionMessage handleException(IllegalArgumentException ex) {
        return new JsonExceptionMessage(ERROR_MESSAGE_TITLE, ex.getMessage());
    }
}

