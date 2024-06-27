package com.rodolfonemes.livraria.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class BookNotFoundException extends HttpClientErrorException {

  public BookNotFoundException(HttpStatus status, String statusText) {
    super(status, statusText);
  }

}
