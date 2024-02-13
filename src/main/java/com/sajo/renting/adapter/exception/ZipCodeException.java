package com.sajo.renting.adapter.exception;

public class ZipCodeException extends RuntimeException {

    public static final String ZIP_CODE_ERROR_MESSAGE = "The Zip Code does not have the right format";

    public ZipCodeException() {
        super(ZIP_CODE_ERROR_MESSAGE);
    }
}
