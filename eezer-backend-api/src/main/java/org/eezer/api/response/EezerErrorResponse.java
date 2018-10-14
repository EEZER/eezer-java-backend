package org.eezer.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class EezerErrorResponse {

    private boolean success;
    private String message;
    private String message_extra;

}
