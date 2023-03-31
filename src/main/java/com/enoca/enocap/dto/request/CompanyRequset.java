package com.enoca.enocap.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRequset {

   // @Size(min = 1, max =50,message = "Please Current Company Name")
    @NotBlank(message = "Please provide Company Name")
    @Column(length =50,nullable = false)
    private String companyName;
   // @Size(min = 1, max =50,message = "Please Current Company Name")
    @NotBlank(message = "Please provide Company Name")
    @Column(length =50,nullable = false)
    private String companyType;
  //  @Size(min = 1, max =200,message = "Please Current Company Name")
    @NotBlank(message = "Please provide Company Name")
    @Column(length =200,nullable = false)
    private String  companyAddress;

    private Integer companyWorker;
}
