package com.enoca.enocap.dto.request;

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
public class WorkerRequest {
    private String workerFirstName;
    private String workerLastName;
    private Long companyId;
    private String workerType;
    private String workerAddress;
    private Long workerSalary;
}
