package org.eezer.service.domain.service;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

import org.eezer.api.valueobject.User;
import org.eezer.service.domain.model.UserModel;
import org.eezer.service.domain.repository.UserRepository;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

/**
 * Default implementation of the {@link UserService} interface.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     */
    public User addUser(@NotNull User user) {

        UserModel userModel = conversionService.convert(user, UserModel.class);

        userRepository.save(userModel);

        return user;
    }

    /**
     * {@inheritDoc}
     */
    public void removeUser(@NotNull String username) {

        UserModel user = userRepository.getByUsername(username);

        if (user != null) {
            userRepository.delete(user);
        }
    }

    /**
     * {@inheritDoc}
     */
    public List<User> getUsers() {

        List<UserModel> userModelList = userRepository.findAll();
        return Arrays.asList(conversionService.convert(userModelList, User[].class));
    }

}
