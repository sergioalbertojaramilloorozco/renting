package com.sajo.renting.adapter.zipcode;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ZipCodeDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String zip;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lat;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lng;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String city;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String stateId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String stateName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String housesRegistered;

}
