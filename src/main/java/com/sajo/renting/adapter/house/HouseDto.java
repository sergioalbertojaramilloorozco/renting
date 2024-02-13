package com.sajo.renting.adapter.house;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class HouseDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String address;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String neighborhood;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String town;

    private String zipCode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String housesRegistered;

}
