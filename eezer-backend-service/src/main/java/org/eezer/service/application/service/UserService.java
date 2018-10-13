package org.eezer.service.application.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.eezer.service.domain.model.User;

/**
 * The user service is resposible of handling all user requests,
 * such as add user, remove user and edit user.
 */
public interface UserService {

    /**
     * Create and persist a new user.
     *
     * @param user the new users data
     *
     * @return the new user object, if successful
     */
    User addUser(@NotNull User user);

    /**
     * Remove an existing user by it's username,
     *
     * @param username the username to remove
     */
    void removeUser(@NotNull String username);

    /**
     * Fetch all existing users in the system.
     *
     * @return a list of all existing users
     */
    List<User> getUsers();
}
