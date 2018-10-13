package org.eezer.service.domain.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ErrorResponse {

    private boolean success;
    private String message;
    private String message_extra;

}
