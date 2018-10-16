package org.eezer.service.domain.service;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

import org.eezer.api.valueobject.User;
import org.eezer.service.domain.model.UserModel;
import org.eezer.service.domain.repository.UserRepository;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * {@inheritDoc}
     */
    @Override
    public User addUser(@NotNull User user) {

        UserModel userModel = conversionService.convert(user, UserModel.class);

        userModel.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        userRepository.save(userModel);

        // mask password before return
        user.setPassword("***");

        return user;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeUser(@NotNull String username) {

        UserModel user = userRepository.getByUsername(username);

        if (user != null) {
            userRepository.delete(user);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> getUsers() {

        List<UserModel> userModelList = userRepository.findAll();
        return Arrays.asList(conversionService.convert(userModelList, User[].class));
    }

}
