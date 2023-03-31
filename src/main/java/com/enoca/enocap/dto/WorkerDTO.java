package com.enoca.enocap.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkerDTO {

    private Long id;
    private String workerFirstName;
    private String wokerLastName;
    private String workerType;
    private String workerAddress;
    private Long workerSalary;
}
