package org.eezer.service.domain.repository;

import org.eezer.service.domain.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    /**
     * Get a user by it's username.
     *
     * @param username the username to find
     * @return the user object, if found
     */
    User getByUsername(String username);

}