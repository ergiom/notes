package com.example.notes.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NotebookResponseExceptionHandler {

    @ExceptionHandler(value = NotebookNotFoundException.class)
    public ErrorResponse handleNotebookNotFoundException(NotebookNotFoundException exception) {
        return new ErrorResponseException(HttpStatus.NOT_FOUND);
    }
}
