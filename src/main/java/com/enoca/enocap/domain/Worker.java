package com.enoca.enocap.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tbl_worker")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=50,nullable = false)
    @Size(min = 3,max = 50,message = "Please Enter Correct WorkerFirstName")
    private String workerFirstName;

    @Column(length=50,nullable = false)
    @Size(min = 3,max = 50,message = "Please Enter Correct WorkerFirstName")
    private String wokerLastName;

    @Column(length=50,nullable = false)
    @Size(min = 2,max = 50,message = "Please Enter Correct WorkerFirstName")
    private String workerType;

    @Column(length=200,nullable = false)
    @Size(min = 3,max = 200,message = "Please Enter Correct WorkerFirstName")
    private String workerAddress;

    @Column(length=5,nullable = false)
    private Long workerSalary;
}
