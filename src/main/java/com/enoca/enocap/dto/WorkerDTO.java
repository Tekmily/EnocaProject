package com.enoca.enocap.dto;

import com.enoca.enocap.domain.Worker;
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
public class WorkerDTO {
    //DTO, veri taşıma işlemlerini kolaylaştırmak için kullanılan bir tasarım deseni ile farklı katmanlar arasında veri transferi yapıyoruz.
    private Long id;
    private String workerFirstName;
    private String workerLastName;
    private String workerType;
    private String workerAddress;
    private Long workerSalary;
    private Long companyId;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
    public static WorkerDTO fromWorker(Worker worker) {
        WorkerDTO workerDTO = new WorkerDTO();
        workerDTO.setId(worker.getId());
        workerDTO.setWorkerFirstName(worker.getWorkerFirstName());
        workerDTO.setWorkerLastName(worker.getWorkerLastName());
        workerDTO.setWorkerType(worker.getWorkerType());
        workerDTO.setWorkerAddress(worker.getWorkerAddress());
        workerDTO.setWorkerSalary(worker.getWorkerSalary().longValue());
        workerDTO.setCompanyId(worker.getCompany().getId());
        return workerDTO;
    }
}
