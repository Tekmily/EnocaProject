package com.enoca.enocap.dto;

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
public class CompanyDTO {
    //DTO, veri taşıma işlemlerini kolaylaştırmak için kullanılan bir tasarım deseni ile farklı katmanlar arasında veri transferi yapıyoruz.
    private Long id;
    private String companyName;
    private String companyType;
    private String  companyAddress;
}
