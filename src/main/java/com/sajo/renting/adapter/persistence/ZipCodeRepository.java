package com.sajo.renting.adapter.persistence;

import com.sajo.renting.domain.ZipCode;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZipCodeRepository extends MongoRepository<ZipCode, String> {
}
