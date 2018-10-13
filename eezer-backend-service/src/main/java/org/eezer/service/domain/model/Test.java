package org.eezer.service.domain.model;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class Test {

    @Id
    private String id;

    @Length(min = 2, max = 255)
    private String name;

}
