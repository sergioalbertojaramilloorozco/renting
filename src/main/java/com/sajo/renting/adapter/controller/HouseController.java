package com.sajo.renting.adapter.controller;

import com.sajo.renting.adapter.house.HouseDto;
import com.sajo.renting.adapter.house.port.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/house")
@RequiredArgsConstructor
public class HouseController {

    private final HouseService houseService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<HouseDto>>  retrieveHouseById(@PathVariable String id) {
        var houseFound = houseService.retrieveHouse(id);
        if (houseFound.isPresent()) return ResponseEntity.ok(houseFound);
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<HouseDto>> retrieveAllHouses() {
        return ResponseEntity.ok(houseService.retrieveHouses());
    }

    @PostMapping
    public ResponseEntity<HouseDto> saveHouse(@RequestBody HouseDto houseDto) {
        return ResponseEntity.created(URI.create("/v1/house")).body(houseService.saveHouse(houseDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HouseDto> updateHouse(@RequestBody HouseDto houseDto,  @PathVariable String id) {
        return ResponseEntity.ok(houseService.update(id, houseDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHouse(@PathVariable String id) {
        houseService.deleteHouse(id);
        return ResponseEntity.ok("House deleted for ID : " + id);
    }

    @GetMapping("/housesByZipCode/{zipCode}")
    public ResponseEntity<HouseDto>  retrieveNumberOfHousesByZipCode(@PathVariable String zipCode) {
        return ResponseEntity.ok(houseService.retrieveNumberOfHousesByZipCode(zipCode));
    }
}
