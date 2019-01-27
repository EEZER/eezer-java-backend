package org.eezer.api.request;

import org.eezer.api.enums.EezerRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class EezerAddUserRequest {

    private String username;
    private String password;
    private EezerRole role;
    private String realName;
    private String phone;
    private String email;
    private String organization;
    private String other;

}
