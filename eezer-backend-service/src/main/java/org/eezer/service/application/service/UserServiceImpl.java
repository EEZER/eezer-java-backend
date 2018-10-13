package org.eezer.service.application.service;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

import org.eezer.service.domain.model.User;
import org.eezer.service.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * Default implementation of the {@link UserService} interface.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    /**
     * {@inheritDoc}
     */
    public User addUser(@NotNull User user) {

        return userRepository.save(user);
    }

    /**
     * {@inheritDoc}
     */
    public void removeUser(@NotNull String username) {

        User user = userRepository.getByUsername(username);

        if (user != null) {
            userRepository.delete(user);
        }
    }

    /**
     * {@inheritDoc}
     */
    public List<User> getUsers() {

        return userRepository.findAll();
    }

}
