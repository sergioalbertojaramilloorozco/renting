package com.sajo.renting.adapter.persistence;

import com.sajo.renting.domain.House;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends MongoRepository<House, String> {
}
