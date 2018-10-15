package org.eezer.service.application.service;

import javax.annotation.Resource;
import javax.validation.ConstraintViolationException;

import org.eezer.api.enums.EezerErrorCode;
import org.eezer.api.exception.EezerException;
import org.eezer.api.response.EezerResponse;
import org.eezer.api.valueobject.User;
import org.eezer.service.domain.service.UserService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Resource
    private UserService userService;

    /**
     * {@inheritDoc}
     */
    public EezerResponse addUser(User user) {

        try {

            return this.toResponse(userService.addUser(user));
        } catch (Exception e) {

            throw toError(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    public EezerResponse removeUser(String username) {

        try {

            userService.removeUser(username);
            return this.toResponse(username);
        } catch (Exception e) {

            throw toError(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    public EezerResponse getUsers() {

        try {

            return this.toResponse(userService.getUsers());
        } catch (Exception e) {

            throw toError(e);
        }
    }

    /**
     * Build the response object with data.
     *
     * @param data the data to include
     * @return the final response object
     */
    private EezerResponse toResponse(Object data) {

        return EezerResponse.builder()
                .success(true)
                .data(data)
                .build();
    }

    /**
     * Catch exceptions and convert them to a proper Eezer exception.
     *
     * @param e the original exception
     * @return the new Eezer exception
     */
    private EezerException toError(Exception e) {

        log.error("Got an exception when processing request, e: {}", e);

        if (e instanceof ConstraintViolationException) {

            throw new EezerException(EezerErrorCode.ValidationError, e.getMessage());
        } else if (e instanceof DuplicateKeyException) {

            throw new EezerException(EezerErrorCode.UniqueIndexError, "username already exists");
        }

        throw new EezerException(EezerErrorCode.Unhandled, "unhandled exception");
    }

}
