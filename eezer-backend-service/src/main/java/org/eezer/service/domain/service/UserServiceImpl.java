package org.eezer.service.domain.service;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

import org.eezer.api.request.EezerAddUserRequest;
import org.eezer.api.request.EezerEditUserRequest;
import org.eezer.api.valueobject.User;
import org.eezer.service.domain.exception.RecordNotFoundException;
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
    public User addUser(@NotNull EezerAddUserRequest request) {

        UserModel userModel = conversionService.convert(request, UserModel.class);
        userModel.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));

        userRepository.save(userModel);

        return conversionService.convert(userModel, User.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeUser(String username) {

        UserModel user = userRepository.getByUsername(username);

        if (user != null) {
            userRepository.delete(user);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User editUser(String username, EezerEditUserRequest request) {

        UserModel user = userRepository.getByUsername(username);

        if (user != null) {

            UserModel editedUser = user.toBuilder()
                    .realName(request.getRealName() != null ? request.getRealName() : user.getRealName())
                    .phone(request.getPhone() != null ? request.getPhone() : user.getPhone())
                    .email(request.getEmail() != null ? request.getEmail() : user.getEmail())
                    .organization(request.getOrganization() != null ? request.getOrganization() : user.getOrganization())
                    .other(request.getOther() != null ? request.getOther() : user.getOther())
                    .build();

            userRepository.save(editedUser);
            return conversionService.convert(editedUser, User.class);
        }

        throw new RecordNotFoundException("No user found with username " + username);
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
