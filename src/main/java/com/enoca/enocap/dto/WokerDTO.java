package com.enoca.enocap.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WokerDTO {

    private Long id;
    private String workerFirstName;
    private String wokerLastName;
    private String workerType;
    private String workerAddress;
    private Long workerSalary;
}
