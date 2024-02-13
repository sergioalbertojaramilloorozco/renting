package com.sajo.renting.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Builder
@Document
public class House {

    private String id;
    private String address;
    private String neighborhood;
    private String town;
    private String zipCode;
}
