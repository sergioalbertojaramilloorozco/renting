package com.sajo.renting.adapter.exception;

import com.sajo.renting.domain.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdviceResponse extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ZipCodeException.class)
    public ResponseEntity<ResponseError> houseWasNotCreatedForBadZipCode(){
        return new ResponseEntity<>(new ResponseError(ZipCodeException.ZIP_CODE_ERROR_MESSAGE), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(AddressException.class)
    public ResponseEntity<ResponseError> houseWasNotCreatedForBadAddress(){
        return new ResponseEntity<>(new ResponseError(AddressException.ADDRESS_ERROR_MESSAGE), HttpStatus.NOT_ACCEPTABLE);
    }
}
