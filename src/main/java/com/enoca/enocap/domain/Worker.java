package com.enoca.enocap.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
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
@Table(name = "tbl_worker")//tbl_worker adında bir tablo oluşturur
public class Worker {
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
    @Column(length=50,nullable = false)//50 karakter uzunluğunda veri girişi yapılacağını ifade eder ve kolon oluşturur
    @Size(min = 3,max = 50,message = "Please Enter Correct WorkerFirstName")//minimum =3 maxsimum=50 karakter girilebileceği ve kıriterlerin dışına çıkarsa message = "Please Correct Company Name" vereceğini ifade eder.
    @NotNull(message = "Please provide Worker First Name")//Boş geçilemez olduğunu ifade eder
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

    @Column(length=5,nullable = false)
    private Long workerSalary;
    /**
     * @ManyToOne: Bu anotasyon, bir ilişkiyi işaretler ve birincil sınıfın birçok ikincil sınıfına sahip olduğunu belirtir.
     * @JoinColumn: Bu anotasyon, ilişkili birincil anahtar sütununu belirtmek için kullanılır.
     * Bu anotasyon, @ManyToOne veya @OneToOne anotasyonlarıyla birlikte kullanılır ve
     * bu anotasyonlardan biri olmadan kullanılamaz.
     */
    @ManyToOne
    @JoinColumn(name="company_id")//tbl_worker tablocasuna company_id adında ManyToOne ilişkisi kurarak kolon eklememizi sağlar
    private Company company;//Company class ile iletişime geçeceğimiz kısım.
    /**
     * Company class private tanımlandığı için Get ve Set method kullanarak iletişim kurulur.
    */
    public Company getCompany() {

        return company;
    }

    public void setCompany(Company company) {

        this.company = company;
    }
}
