package com.sajo.renting.application;

import com.sajo.renting.adapter.mapper.ZipCodeMapper;
import com.sajo.renting.adapter.persistence.ZipCodeRepository;
import com.sajo.renting.adapter.zipcode.ZipCodeDto;
import com.sajo.renting.adapter.zipcode.port.ZipCodeService;
import com.sajo.renting.domain.House;
import com.sajo.renting.domain.ZipCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ZipCodeImpl implements ZipCodeService {

    private final ZipCodeRepository zipCodeRepository;

    private final ZipCodeMapper zipCodeMapper;

    private final MongoTemplate mongoTemplate;

    @Override
    public List<ZipCodeDto> retrieveAllZipCode() {
        return zipCodeMapper.listZipCodeDto(zipCodeRepository.findAll());
    }

    @Override
    public Optional<ZipCodeDto> retrieveByZipCode(String id) {
        Query query = new Query();
        String housesByZipCode = null;
        query.addCriteria(Criteria.where("zip").is(id));
        var findByZipCode =  mongoTemplate.findOne(query, ZipCode.class);
        if (findByZipCode != null) {
            housesByZipCode = getHousesByZipCode(id);
        }
        return zipCodeMapper.zipCodeToDto(Optional.ofNullable(findByZipCode), housesByZipCode);
    }

    private String getHousesByZipCode(String id) {
        String housesByZipCode;
        var houses = mongoTemplate.findAll(House.class);
        housesByZipCode = String.valueOf(houses.stream()
                .filter(zipCodeArea -> id.equals(zipCodeArea.getZipCode()))
                .count());
        return housesByZipCode;
    }
}
