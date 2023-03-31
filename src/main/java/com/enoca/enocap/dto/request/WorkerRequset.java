package com.enoca.enocap.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkerRequset {

    @Column(length=50,nullable = false)
    @NotBlank(message = "Please Provide Worker First Name")
    private String workerFirstName;

    @Column(length=50,nullable = false)
    @NotBlank(message = "Please Provide Worker Last Name")
    private String wokerLastName;

    @Column(length=50,nullable = false)
    @NotBlank(message = "Please Provide Worker Type")
    private String workerType;

    @Column(length=200,nullable = false)
    @NotBlank(message = "Please Provide Worker Address")
    private String workerAddress;

    @Column(length=5,nullable = false)
    private Long workerSalary;
}
