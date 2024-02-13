package com.sajo.renting.adapter.exception;

public class HouseNotFound extends RuntimeException {

    private static  final String HOUSE_NOT_FOUND = "House not found";

    public HouseNotFound() {
        super(HOUSE_NOT_FOUND);
    }
}
