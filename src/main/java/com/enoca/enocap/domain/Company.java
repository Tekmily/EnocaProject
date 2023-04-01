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
/**
 * @Getter: Lombok kütüphanesinden bir anotasyondur ve sınıfın tüm alanları için getter yöntemleri oluşturur.
 * @Setter: Lombok kütüphanesinden bir anotasyondur ve sınıfın tüm alanları için setter yöntemleri oluşturur.
 * @AllArgsConstructor: Lombok kütüphanesinden bir anotasyondur ve tüm alanları içeren bir yapılandırıcı (constructor) oluşturur.
 * @NoArgsConstructor: Lombok kütüphanesinden bir anotasyondur ve parametresiz bir yapılandırıcı (constructor) oluşturur.
 * @Entity: Bu anotasyon, bir JPA varlığı olarak belirtilen sınıfı işaretler.
 * @Table: Bu anotasyon, bir veritabanı tablosu adını belirtmek için kullanılır.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tbl_Company")//tbl_Company adında bir tablo oluşturur
public class Company {
    /**
     * @Id: Bu anotasyon, bir alanın birincil anahtar (primary key) olduğunu işaretler.
     * @GeneratedValue: Bu anotasyon, birincil anahtarın otomatik olarak oluşturulacağını belirtir.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Eşsiz olacağını IDENTITY ile belirtilir.
    private Long id;
    /**
     * @Size: Bu anotasyon, bir alanın en fazla kaç karakter içerebileceğini belirtir.
     * @NotNull: Bu anotasyon, bir alanın null olamayacağını belirtir.
     * @Column: Bu anotasyon, bir alanın bir veritabanı sütunu ile eşleştiğini işaretler.
    */
    @Size(min = 1, max =50,message = "Please Correct Company Name")//minimum =1 maxsimum=50 karakter girilebileceği ve kıriterlerin dışına çıkarsa message = "Please Correct Company Name" vereceğini ifade eder.
    @NotNull(message = "Please provide Company Name")//Boş geçilemez olduğunu ifade eder
    @Column(length =50,nullable = false)//50 karakter uzunluğunda veri girişi yapılacağını ifade eder ve kolon oluşturur
    private String companyName;//kolunun adını ve türünü ifade eder

    @Size(min = 1, max =50,message = "Please Current Company Name")
    @NotNull(message = "Please provide Company Type")
    @Column(length =50,nullable = false)
    private String companyType;

    @Size(min = 1, max =200,message = "Please Correct Company Name")
    @NotNull(message = "Please provide Company Address")
    @Column(length =200,nullable = false)
    private String  companyAddress;
    //@OneToMany: Bu anotasyon, bir ilişkiyi işaretler ve birincil sınıfın birçok ikincil sınıfa sahip olduğunu belirtir.
    @OneToMany(mappedBy = "company")//worker daki company kolanunu ontomany olarak bağlantı kurar
    private List<Worker> workersList = new ArrayList<>();//Workerdaki companydeki verileri list halinde tutar.
}
