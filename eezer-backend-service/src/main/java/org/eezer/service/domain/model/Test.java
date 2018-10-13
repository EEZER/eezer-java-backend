package org.eezer.service.domain.model;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Document
@AllArgsConstructor
public class Test {

    @Id
    private String id;

    @Indexed(unique = true)
    @Length(min = 2, max = 255)
    private String name;

}
