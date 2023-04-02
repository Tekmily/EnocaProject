package com.enoca.enocap.dto;

import com.enoca.enocap.domain.Worker;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkerDTO {

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
