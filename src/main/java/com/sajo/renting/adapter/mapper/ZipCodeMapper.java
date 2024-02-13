package com.sajo.renting.adapter.mapper;

import com.sajo.renting.adapter.zipcode.ZipCodeDto;
import com.sajo.renting.domain.ZipCode;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ZipCodeMapper {

    public List<ZipCodeDto> listZipCodeDto(List<ZipCode> zipCodeList) {
        return zipCodeList.stream().map(dao -> ZipCodeDto.builder()
                        .zip(dao.getZip())
                        .lat(dao.getLat())
                        .lng(dao.getLng())
                        .stateId(dao.getStateId())
                        .stateName(dao.getStateName())
                        .build())
                .toList();
    }

    public Optional<ZipCodeDto> zipCodeToDto(Optional<ZipCode> zipCode, String housesRegistered) {
        return zipCode.map(dao -> ZipCodeDto.builder()
                .zip(dao.getZip())
                .lat(dao.getLat())
                .lng(dao.getLng())
                .city(dao.getCity())
                .stateId(dao.getStateId())
                .stateName(dao.getStateName())
                .housesRegistered(housesRegistered)
                .build());
    }
}
