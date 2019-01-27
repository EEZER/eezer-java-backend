package org.eezer.api.valueobject;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Coordinate {

    @NotNull
    @NotEmpty
    private Double lat;

    @NotNull
    @NotEmpty
    private Double lng;

}
