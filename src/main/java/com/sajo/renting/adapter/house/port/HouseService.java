package com.sajo.renting.adapter.house.port;

import com.sajo.renting.adapter.house.HouseDto;

import java.util.List;
import java.util.Optional;

public interface HouseService {

    Optional<HouseDto> retrieveHouse(String id);

    List<HouseDto> retrieveHouses();

    HouseDto saveHouse(HouseDto houseDto);

    void deleteHouse(String id);

    HouseDto update(String id, HouseDto houseDto);

    HouseDto retrieveNumberOfHousesByZipCode(String zipCode);
}
