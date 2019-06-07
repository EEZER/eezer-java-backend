package org.eezer.api.valueobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.eezer.api.enums.EezerRole;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class User {

    private String username;
    // private String password; // we don't return password
    private EezerRole role;
    private String realName;
    private String phone;
    private String email;
    private String organization;
    private String other;
    private String createdTime;

}
