package com.enoca.enocap.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * @Getter: Sınıfta tanımlı olan private değişkenlere erişmek için kullanılan getter metodlarını otomatik olarak oluşturur.
 * @Setter: Sınıfta tanımlı olan private değişkenlere değer atamak için kullanılan setter metodlarını otomatik olarak oluşturur.
 * @AllArgsConstructor: Sınıfın tüm özelliklerini kapsayan bir constructor (kurucu metod) oluşturur.
 * @NoArgsConstructor: Parametresiz bir constructor (kurucu metod) oluşturur.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRequest {
    //Request edilecek değerler
    private String companyName;
    private String companyType;
    private String  companyAddress;
}
