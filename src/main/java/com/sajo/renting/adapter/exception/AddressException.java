package com.sajo.renting.adapter.exception;

public class AddressException extends RuntimeException {

    public static final String ADDRESS_ERROR_MESSAGE = "Address can not be empty";

    public AddressException() {
        super(ADDRESS_ERROR_MESSAGE);
    }
}
