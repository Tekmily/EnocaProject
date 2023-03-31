package com.enoca.enocap.controller;

import com.enoca.enocap.domain.Company;
import com.enoca.enocap.domain.Worker;
import com.enoca.enocap.dto.CompanyDTO;
import com.enoca.enocap.dto.request.CompanyRequest;
import com.enoca.enocap.dto.response.EPResponse;
import com.enoca.enocap.dto.response.ResponseMessage;
import com.enoca.enocap.mapper.CompanyMapper;
import com.enoca.enocap.service.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @RestController, Spring Framework'te bir sınıf seviyesi anotasyonudur ve Spring MVC'de RESTful web hizmetleri oluşturmak için kullanılır.
 *@RequiredArgsConstructor: Lombok anotasyonudur ve final olarak tanımlanmış tüm sınıf değişkenleri için otomatik olarak bir constructor üretir.
 * @RequestMapping: Spring MVC'de bir metot seviyesi anotasyonudur ve belirtilen URL yoluna sahip HTTP isteklerini işlemek için kullanılır.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {
    /**
     * companyService kullanılarak servis enjectte edilir
     * companyMapper kullanılarak mapper enjectte edilir
     */
    private final CompanyService companyService;
    private final CompanyMapper companyMapper;

    /**
     * @PostMapping: Spring MVC'de bir metot seviyesi anotasyonudur ve belirtilen URL yoluna sahip HTTP POST isteklerini işlemek için kullanılır.
     * createCompany methodu ile kullanıcıdan alınan verileri uygun biçinde veritabanında kaydetmek için kullanılır.
     */
    @PostMapping("/create")
    public ResponseEntity<EPResponse> createCompany(@Valid @RequestBody CompanyRequest companyRequset){
        Company company=companyMapper.companyRequsetToCompany(companyRequset);//Kullanıcıdan gelen Request'i Company object'te dönüştürmek için kullanılır
        companyService.save(company);//Company den alınan verileri Servise kaydetmek için kullanılır.
        EPResponse epResponse=new EPResponse("Company successfully created",true);
        // Response olarak geri Created ve Successfully bilgisaini oluşturur.
        return new ResponseEntity<>(epResponse, HttpStatus.CREATED);//kaydedildiğine dair epResponse taki bilgileri geri döndürür.

    }
    @GetMapping//@GetMapping, Spring MVC'de bir metot seviyesi anotasyonudur ve belirtilen URL yoluna sahip HTTP GET isteklerini işlemek için kullanılır.
    //getAllCompany method'u Veritabanında bulunan tüm bilgileri ekrana listeler
    public ResponseEntity<List<CompanyDTO>> getAllCompany(){
       List<Company> companyList= companyService.getAll();//Service'ten alına tüm listeyi companyList ekler
        List<CompanyDTO> companyDTOList=companyMapper.companyListToCompanyDTOListMap(companyList);//Company object'in companyList tesindeki tüm verileri CompanyDTolist dönüştürür
        return ResponseEntity.ok(companyDTOList);//companyDTOList'in başarılı şekilde döndürüldüğüne dair bilgi iletir.Verileri Ekrana yazar
    }

    @GetMapping("/{id}")//getByIdCompany method'u istenilen ID deki verileri ekrana yazdırır
    public ResponseEntity<CompanyDTO> getByIdCompany(@PathVariable("id")Long id) {
        Company company=companyService.getCompanyById(id);//Service'ten ID ile istenilen verileri Company object'e aktarır.
        CompanyDTO companyDTOList=companyMapper.companyToCompanyDTO(company);//Company object'teki verileri CompanyDTOList object'e aktarır
        return ResponseEntity.ok(companyDTOList);//companyDTOList'in başarılı şekilde döndürüldüğüne dair bilgi iletir.Verileri Ekrana yazar.
    }
    @DeleteMapping("/{id}")//@DeleteMapping: Spring MVC'de bir metot seviyesi anotasyonudur ve belirtilen URL yoluna sahip HTTP DELETE isteklerini işlemek için kullanılır.
    //getDeleteByIdCompany method'u istenilen ID ile silme işlemi yapar.
    public ResponseEntity<EPResponse> getDeleteByIdCompany(@PathVariable Long id) {//@PathVariable: Spring MVC'de bir metot seviyesi anotasyonudur ve belirtilen URL yolundaki değişkenleri bir değişkene atanmak için kullanılır.
        companyService.deleteByIdCompany(id);//Service ID ile silme işlemi yapar
        EPResponse epResponse=new EPResponse(ResponseMessage.COMPANY_DELETE_RESPONSE_MESSAGE,true);//Veri silme işlemi düzgün gerçekleşmiş ise başarılı bilgisini veriri şayet veritabanında olmayan ID ile işlem yapılıyor ise Exception fırları
        return ResponseEntity.ok(epResponse);//epResponse aldığı veriyi ekrana yazar.
    }
    @PutMapping("/{id}")//@PutMapping: Spring MVC'de bir metot seviyesi anotasyonudur ve belirtilen URL yoluna sahip HTTP PUT isteklerini işlemek için kullanılır.
    //@PathVariable: Spring MVC'de bir metot seviyesi anotasyonudur ve belirtilen URL yolundaki değişkenleri bir değişkene atanmak için kullanılır.
    //@RequestBody: Spring MVC'de bir metot seviyesi anotasyonudur ve gelen HTTP isteği gövdesindeki verileri bir nesne olarak almak için kullanılır.

    //getUpdateByIdCompany method'u istenilen ID ile update(güncelleme) işlemi yapar.
    public ResponseEntity<EPResponse> getUpdateByIdCompany(@PathVariable Long id,
                                                           @RequestBody CompanyRequest companyRequset){
        Company company= companyMapper.companyRequsetToCompany(companyRequset);//companyRequset'ten alına verileri Company object'e dönüştürür.
        companyService.getUpdateByIdCompany(id, company);//ID ve company ile servis güncellemesini yapar.
        EPResponse epResponse=new EPResponse(ResponseMessage.COMPANY_UPDATE_RESPONSE_MESSAGE,true);//Veri silme işlemi düzgün gerçekleşmiş ise başarılı bilgisini veriri şayet veritabanında olmayan ID ile işlem yapılıyor ise Exception fırları
        return  ResponseEntity.ok(epResponse);//epResponse aldığı veriyi ekrana yazar.
    }



}
