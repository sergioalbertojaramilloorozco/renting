package com.sajo.renting.adapter.mapper;

import com.sajo.renting.adapter.exception.HouseNotFound;
import com.sajo.renting.adapter.house.HouseDto;
import com.sajo.renting.domain.House;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class HouseMapper {

    public House toHouse(HouseDto houseDto) {
        return House.builder()
                .id(houseDto.getId())
                .address(houseDto.getAddress())
                .neighborhood(houseDto.getNeighborhood())
                .town(houseDto.getTown())
                .zipCode(houseDto.getZipCode())
                .build();
    }

    public HouseDto toHouseDto(House house) {
        return HouseDto.builder()
                .id(house.getId())
                .address(house.getAddress())
                .neighborhood(house.getNeighborhood())
                .town(house.getTown())
                .zipCode(house.getZipCode())
                .build();
    }

    public Optional<HouseDto> toHouseDtoOptional(Optional<House> house) {
        if (house.isEmpty()) throw new HouseNotFound();
        return Optional.ofNullable(HouseDto.builder()
                .id(house.get().getId())
                .address(house.get().getAddress())
                .neighborhood(house.get().getNeighborhood())
                .town(house.get().getTown())
                .zipCode(house.get().getZipCode())
                .build());
    }

    public List<HouseDto> toListHouseDto(List<House> houseList) {
        return houseList.stream().map(dao -> HouseDto.builder()
                        .id(dao.getId())
                        .address(dao.getAddress())
                        .neighborhood(dao.getNeighborhood())
                        .town(dao.getTown())
                        .zipCode(dao.getZipCode())
                        .build())
                .toList();
    }
}
