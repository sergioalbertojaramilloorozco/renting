package com.sajo.renting.application;

import com.sajo.renting.adapter.exception.HouseNotFound;
import com.sajo.renting.adapter.house.HouseDto;
import com.sajo.renting.adapter.house.port.HouseService;
import com.sajo.renting.adapter.mapper.HouseMapper;
import com.sajo.renting.adapter.persistence.HouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HouseImpl implements HouseService {

    private final HouseRepository houseRepository;

    private final HouseMapper houseMapper;

    @Override
    public Optional<HouseDto> retrieveHouse(String id) {
        return houseMapper.toHouseDtoOptional(houseRepository.findById(id));
    }

    @Override
    public List<HouseDto> retrieveHouses() {
        return houseMapper.toListHouseDto(houseRepository.findAll());
    }

    @Override
    public HouseDto saveHouse(HouseDto houseDto) {
        var responseDB = houseRepository.save(houseMapper.toHouse(houseDto));
        return houseMapper.toHouseDto(responseDB);
    }

    @Override
    public void deleteHouse(String id) {
        houseRepository.deleteById(id);
    }

    @Override
    public HouseDto update(String id, HouseDto houseDto) {
        var house = houseRepository.findById(id);
        if (house.isPresent()) {
            return houseMapper.toHouseDto(
                    houseRepository.save(
                            houseMapper.toHouse(houseUpdated(id, houseDto))
                    )
            );
        } else {
            throw new HouseNotFound();
        }
    }

    @Override
    public HouseDto retrieveNumberOfHousesByZipCode(String zipCode) {
        var listByZipCode = houseMapper.toListHouseDto(houseRepository.findAll());
        var housesForZipCode = listByZipCode.stream()
                .filter(house -> zipCode.equals(house.getZipCode()))
                .toList();
        return buildHouse(zipCode, housesForZipCode);
    }

    private static HouseDto buildHouse(String zipCode, List<HouseDto> housesForZipCode) {
        var townFound = housesForZipCode.stream().findFirst().map(HouseDto::getTown).orElse(null);
        return HouseDto.builder()
                .town(townFound)
                .zipCode(zipCode)
                .housesRegistered(String.valueOf(housesForZipCode.size()))
                .build();
    }

    private HouseDto houseUpdated(String id, HouseDto house) {
        return HouseDto.builder()
                .id(id)
                .address(house.getAddress())
                .neighborhood(house.getNeighborhood())
                .town(house.getTown())
                .zipCode(house.getZipCode())
            .build();
    }
}
