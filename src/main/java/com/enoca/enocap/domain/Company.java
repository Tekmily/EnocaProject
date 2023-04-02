package com.enoca.enocap.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.executable.ValidateOnExecution;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tbl_Company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1, max =50,message = "Please Correct Company Name")
    @NotNull(message = "Please provide Company Name")
    @Column(length =50,nullable = false)
    private String companyName;

    @Size(min = 1, max =50,message = "Please Current Company Name")
    @NotNull(message = "Please provide Company Type")
    @Column(length =50,nullable = false)
    private String companyType;

    @Size(min = 1, max =200,message = "Please Correct Company Name")
    @NotNull(message = "Please provide Company Address")
    @Column(length =200,nullable = false)
    private String  companyAddress;

    @OneToMany(mappedBy = "company")
    private List<Worker> workersList = new ArrayList<>();
}
