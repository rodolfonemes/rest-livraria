package com.rodolfonemes.livraria.controller;

import com.rodolfonemes.livraria.exception.BookNotFoundException;
import com.rodolfonemes.livraria.exception.DuplicatedBookException;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler({
      BookNotFoundException.class,
      DuplicatedBookException.class
  })
  protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
    return handleExceptionInternal(
        ex,
        ex.getMessage(),
        new HttpHeaders(),
        HttpStatus.BAD_REQUEST,
        request
    );
  }

  @ExceptionHandler({
      EntityNotFoundException.class
  })
  protected ResponseEntity<Object> handleNotFound(RuntimeException ex, WebRequest request) {
    return handleExceptionInternal(
        ex,
        "Livro não encontrado.",
        new HttpHeaders(),
        HttpStatus.NOT_FOUND,
        request
    );
  }

}
