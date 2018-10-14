package org.eezer.service.converter;

import java.util.Date;

import org.eezer.api.valueobject.User;
import org.eezer.service.domain.model.UserModel;
import org.springframework.core.convert.converter.Converter;

public class UserDTO2UserModelConverter implements Converter<User, UserModel> {

    /**
     * {@inheritDoc}
     */
    public UserModel convert(User source) {

        return UserModel.builder()
                .username(source.getUsername())
                .password(source.getPassword())
                .role(source.getRole())
                .realName(source.getRealName())
                .phone(source.getPhone())
                .email(source.getEmail())
                .organization(source.getOrganization())
                .other(source.getOther())
                .createdTime(new Date())
                .build();
    }
}
