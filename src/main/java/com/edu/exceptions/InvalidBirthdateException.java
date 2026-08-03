
package com.edu.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Invalid birthdate format") 
 public class InvalidBirthdateException extends RuntimeException {
 }
