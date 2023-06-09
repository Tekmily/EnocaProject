package com.enoca.enocap.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "Please provide Worker First Name")
    private String workerFirstName;

    @Column(length=50,nullable = false)
    @Size(min = 3,max = 50,message = "Please Enter Correct WorkerFirstName")
    @NotNull(message = "Please provide Worker Last Name")
    private String workerLastName;

    @Column(length=50,nullable = false)
    @Size(min = 2,max = 50,message = "Please Enter Correct WorkerFirstName")
    @NotNull(message = "Please provide Worker Type")
    private String workerType;

    @Column(length=200,nullable = false)
    @Size(min = 3,max = 200,message = "Please Enter Correct WorkerFirstName")
    @NotNull(message = "Please provide Worker Address")
    private String workerAddress;


    private Long workerSalary;

    @ManyToOne
    @JoinColumn(name="company_id")
    private Company company;

    public Company getCompany() {

        return company;
    }

    public void setCompany(Company company) {

        this.company = company;
    }
}
