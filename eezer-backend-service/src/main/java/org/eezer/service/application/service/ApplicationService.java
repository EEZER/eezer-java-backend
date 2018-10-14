package org.eezer.service.application.service;

import org.eezer.api.exception.EezerException;
import org.eezer.api.response.EezerResponse;
import org.eezer.api.valueobject.User;

public interface ApplicationService {

    /**
     * Handles a "add user" request.
     *
     * @param user the user data
     * @return a response object if successful
     *
     * @throws EezerException if unsuccessful
     */
    EezerResponse addUser(User user);

    /**
     * Handles a "remove user" request.
     *
     * @param username the username to remove
     * @return a response object if successful
     *
     * @throws EezerException if unsuccessful
     */
    EezerResponse removeUser(String username);

    /**
     * Handles a "get users" request.
     *
     * @return a response object if successful
     *
     * @throws EezerException if unsuccessful
     */
    EezerResponse getUsers();
}
