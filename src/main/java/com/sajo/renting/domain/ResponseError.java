package com.sajo.renting.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseError {

    private String message;

    public ResponseError(String message) {
        this.message = message;
    }
}
