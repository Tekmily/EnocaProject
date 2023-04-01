package com.enoca.enocap.controller;

import com.enoca.enocap.domain.Company;
import com.enoca.enocap.domain.Worker;
import com.enoca.enocap.dto.WorkerDTO;
import com.enoca.enocap.dto.request.WorkerRequest;
import com.enoca.enocap.dto.response.EPResponse;
import com.enoca.enocap.dto.response.ResponseMessage;
import com.enoca.enocap.exception.Message.ErrorMessage;
import com.enoca.enocap.exception.ResourceNotFoundException;
import com.enoca.enocap.mapper.WorkerMapper;
import com.enoca.enocap.repository.WorkerRepository;
import com.enoca.enocap.service.CompanyService;
import com.enoca.enocap.service.WorkerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
        /**
        *@RestController, Spring Framework'te bir sınıf seviyesi anotasyonudur ve Spring MVC'de RESTful web hizmetleri oluşturmak için kullanılır.
        *@RequiredArgsConstructor: Lombok anotasyonudur ve final olarak tanımlanmış tüm sınıf değişkenleri için otomatik olarak bir constructor üretir.
        * @RequestMapping: Spring MVC'de bir metot seviyesi anotasyonudur ve belirtilen URL yoluna sahip HTTP isteklerini işlemek için kullanılır.
        */
@RestController
@RequiredArgsConstructor
@RequestMapping("/worker")
public class WorkerController {
            /**
             * WorkerService kullanılarak servis enjectte edilir
             * CompanyService kullanılarak servis enjectte edilir
             * WorkerMapper kullanılarak mapper enjectte edilir
             */
    private final WorkerService workerService;
    private final CompanyService companyService;
    private final WorkerMapper workerMapper;
    private final WorkerRepository workerRepository;

            /**
             * @PostMapping: Spring MVC'de bir metot seviyesi anotasyonudur ve belirtilen URL yoluna sahip HTTP POST isteklerini işlemek için kullanılır.
             * createCompany methodu ile kullanıcıdan alınan verileri uygun biçinde veritabanında kaydetmek için kullanılır.
             */

            //http://localhost:8082/company/create
    @PostMapping("/create")
    public ResponseEntity<EPResponse> createWorker(
            @Valid @RequestBody WorkerRequest workerRequest){
        Worker worker = workerMapper.wokerRequsestToWorker(workerRequest);//Kullanıcıdan gelen Request'i worker object'te dönüştürmek için kullanılır
        Company company=companyService.getCompanyById(workerRequest.getCompanyId());//Service'ten ID ile alınan veriyi Company object aktarılır
        worker.setCompany(company);//company deki veriyi worker company colonuna göderilip güncellenir
        workerService.save(worker);//workerService güncellenen veri kayıt edilir
        company.getWorkersList().add(worker);// @OneToMany(mappedBy = "company") bağlatı kurulan companyListe eklenir.
        companyService.save(company);//companyList'e eklenen veriler companyService'a kaydedilir.
        EPResponse epResponse=new EPResponse
                ("Worker Successfully Created",true); // Response olarak geri Created ve Successfully bilgisaini oluşturur.
        return new ResponseEntity<>(epResponse, HttpStatus.CREATED);//kaydedildiğine dair epResponse taki bilgileri geri döndürür.
    }
            //http://localhost:8082/company
    @GetMapping//@GetMapping, Spring MVC'de bir metot seviyesi anotasyonudur ve belirtilen URL yoluna sahip HTTP GET isteklerini işlemek için kullanılır.
    //getAllWorkers method'u Veritabanında bulunan tüm bilgileri ekrana listeler
    public ResponseEntity<List<WorkerDTO>> getAllWorkers(){
        List<WorkerDTO> workerList=workerService.getAllWorkers();//Service'ten alına tüm listeyi workerList ekler
        return new ResponseEntity<>(workerList, HttpStatus.OK);
        //List<WorkerDTO> workerDTOList=workerMapper.workerListToWorkerDTOListMap(workerList);//Worker object'in workerList tesindeki tüm verileri workerDTOList dönüştürür
        //return ResponseEntity.ok(workerDTOList);//workerDTOList'in başarılı şekilde döndürüldüğüne dair bilgi iletir.Verileri Ekrana yazar
    }
    //http://localhost:8082/company/3

   @GetMapping("/{id}")//getByIdWorker method'u istenilen ID deki verileri ekrana yazdırır
   public ResponseEntity<WorkerDTO> getByIdWorker(@PathVariable Long id){
        Worker worker=workerService.getByIdWorker(id);//Service'ten ID ile istenilen verileri Worker object'e aktarır.
       WorkerDTO workerDTO = WorkerDTO.fromWorker(worker);//Worker object'teki verileri workerDTO object'e aktarır
        return ResponseEntity.ok().body(workerDTO);//workerDTO'in başarılı şekilde döndürüldüğüne dair bilgi iletir.Verileri Ekrana yazar.
   }
   //http://localhost:8082/company/4
   @DeleteMapping("/{id}")//@DeleteMapping: Spring MVC'de bir metot seviyesi anotasyonudur ve belirtilen URL yoluna sahip HTTP DELETE isteklerini işlemek için kullanılır.
   //deleteByIdWorker method'u istenilen ID ile silme işlemi yapar.
    public ResponseEntity<EPResponse> deleteByIdWorker(@PathVariable Long id) {//@PathVariable: Spring MVC'de bir metot seviyesi anotasyonudur ve belirtilen URL yolundaki değişkenleri bir değişkene atanmak için kullanılır.
        workerService.deleteByIdWorker(id);//Service ID ile silme işlemi yapar
        EPResponse epResponse=new EPResponse(ResponseMessage.WORKER_DELETE_RESPONSE_MESSAGE,true);//Veri silme işlemi düzgün gerçekleşmiş ise başarılı bilgisini veriri şayet veritabanında olmayan ID ile işlem yapılıyor ise Exception fırları
        return ResponseEntity.ok(epResponse);//epResponse aldığı veriyi ekrana yazar.
   }
   //http://localhost:8082/company/3
   @PutMapping("/{id}")//@PutMapping: Spring MVC'de bir metot seviyesi anotasyonudur ve belirtilen URL yoluna sahip HTTP PUT isteklerini işlemek için kullanılır.
   //@PathVariable: Spring MVC'de bir metot seviyesi anotasyonudur ve belirtilen URL yolundaki değişkenleri bir değişkene atanmak için kullanılır.
   //@RequestBody: Spring MVC'de bir metot seviyesi anotasyonudur ve gelen HTTP isteği gövdesindeki verileri bir nesne olarak almak için kullanılır.
   //updateByIdWorker method'u istenilen ID ile update(güncelleme) işlemi yapar.
    public ResponseEntity<EPResponse> updateByIdWorker(@PathVariable Long id,
                                                       @RequestBody WorkerRequest workerRequest){
        Worker worker=workerMapper.wokerRequsestToWorker(workerRequest);//workerRequest'ten alına verileri Worker object'e dönüştürür.
        workerService.updateByIdWorker(id,worker);//ID ve Worker ile servis güncellemesini yapar.
        EPResponse epResponse=new EPResponse(ResponseMessage.WORKER_UPDATE_RESPONSE_MESSAGE,true);//Veri silme işlemi düzgün gerçekleşmiş ise başarılı bilgisini veriri şayet veritabanında olmayan ID ile işlem yapılıyor ise Exception fırları
        return ResponseEntity.ok(epResponse);//epResponse aldığı veriyi ekrana yazar.
   }


}
