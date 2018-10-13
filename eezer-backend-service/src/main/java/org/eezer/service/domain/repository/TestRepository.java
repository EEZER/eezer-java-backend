package org.eezer.service.domain.repository;

import org.eezer.service.domain.model.Test;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestRepository extends MongoRepository<Test, String> {

    Test getByName(String name);

}