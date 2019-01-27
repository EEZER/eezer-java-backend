package org.eezer.service.domain.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.eezer.api.valueobject.Coordinate;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder(toBuilder = true)
@Document
@ToString
@AllArgsConstructor
public class TransportModel {

    @Id
    private String id;

    @NotNull
    @Indexed(unique = true)
    @Length(min = 10, max = 255)
    private String transportId;

    @NotNull
    @Length(min = 3, max = 255)
    private String driverId;

    @NotNull
    @Length(min = 2, max = 255)
    private String vehicleId;

    private String passengerName;
    private String passengerPhone;
    private String gender;
    private String reason;

    @NotNull
    private List<Coordinate> coordinates;

    @NotNull
    private Integer distance;

    @NotNull
    private Integer duration;

    private String started;
    private String ended;

    private String createdServerTime;
}