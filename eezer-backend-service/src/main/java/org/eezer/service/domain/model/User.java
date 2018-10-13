package org.eezer.service.domain.model;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.eezer.service.domain.api.Role;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@Document
@ToString
@AllArgsConstructor
public class User {

    @Id
    private String id;

    @NotNull
    @Indexed(unique = true)
    @Length(min = 3, max = 255)
    private String username;

    @NotNull
    @Length(min = 8, max = 255)
    private String password;

    @NotNull
    private Role role;

    @NotNull
    @Length(min = 3, max = 255)
    private String realName;

    @NotNull
    private String phone;

    @Email
    @NotNull
    private String email;

    private String organization;

    private String other;

    private Date createdTime;
}
