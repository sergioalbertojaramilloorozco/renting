package com.sajo.renting.adapter.zipcode.port;

import com.sajo.renting.adapter.zipcode.ZipCodeDto;

import java.util.List;
import java.util.Optional;

public interface ZipCodeService {

    List<ZipCodeDto> retrieveAllZipCode();

    Optional<ZipCodeDto> retrieveByZipCode(String id);

}
