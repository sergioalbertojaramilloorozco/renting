package com.sajo.renting.adapter.controller;

import com.sajo.renting.adapter.zipcode.ZipCodeDto;
import com.sajo.renting.adapter.zipcode.port.ZipCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/zipcode")
@RequiredArgsConstructor
public class ZipCodeController {

    private final ZipCodeService zipCodeService;

    @GetMapping
    public ResponseEntity<List<ZipCodeDto>> retrieveAllZipCode() {
        return ResponseEntity.ok(zipCodeService.retrieveAllZipCode());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ZipCodeDto>> retrieveZipCodeById(@PathVariable String id) {
        var zipCodeFound = zipCodeService.retrieveByZipCode(id);
        if (zipCodeFound.isPresent()) return ResponseEntity.ok(zipCodeFound);
        return ResponseEntity.notFound().build();
    }

}
