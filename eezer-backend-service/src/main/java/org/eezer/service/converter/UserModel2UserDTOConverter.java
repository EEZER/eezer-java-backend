package org.eezer.service.converter;

import org.eezer.api.valueobject.User;
import org.eezer.service.domain.model.UserModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserModel2UserDTOConverter implements Converter<UserModel, User> {

    /**
     * {@inheritDoc}
     */
    public User convert(UserModel source) {

        return User.builder()
                .username(source.getUsername())
                .password("***")
                .role(source.getRole())
                .realName(source.getRealName())
                .phone(source.getPhone())
                .email(source.getEmail())
                .organization(source.getOrganization())
                .other(source.getOther())
                .createdTime(source.getCreatedTime())
                .build();
    }
}
