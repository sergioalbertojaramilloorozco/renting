package com.sajo.renting.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Builder
@Document
public class ZipCode {

    private String zip;
    private String lat;
    private String lng;
    private String city;
    private String stateId;
    private String stateName;

}
