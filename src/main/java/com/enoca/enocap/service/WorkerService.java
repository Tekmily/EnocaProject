package com.enoca.enocap.service;

import com.enoca.enocap.domain.Company;
import com.enoca.enocap.domain.Worker;
import com.enoca.enocap.dto.WorkerDTO;
import com.enoca.enocap.dto.request.WorkerRequest;
import com.enoca.enocap.exception.Message.ErrorMessage;
import com.enoca.enocap.exception.ResourceNotFoundException;
import com.enoca.enocap.repository.CompanyRepository;
import com.enoca.enocap.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class WorkerService {
    private final WorkerRepository workerRepository;
    private final CompanyRepository companyRepository;


    public void save(Worker worker){
        workerRepository.save(worker);
    }

    public List<WorkerDTO> getAllWorkers() {
        List<Worker> workers = workerRepository.findAll();
        return workers.stream()
                .map(WorkerDTO::fromWorker)
                .collect(Collectors.toList());
    }
    public  Worker getByIdWorker(Long id) {
        return workerRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException(String.format(ErrorMessage.RESOURCE_NOT_FOUND_MESSAGE, id)));
    }


    public void deleteByIdWorker(Long id) {
        Worker foundWorker =getByIdWorker(id);
        workerRepository.delete(foundWorker);

    }

    public void updateByIdWorker(Long id, WorkerRequest worker) {
        Company company=companyRepository.findById(worker.getCompanyId()).orElseThrow(
                ()-> new ResourceNotFoundException(
                        String.format(ErrorMessage.RESOURCE_NOT_FOUND_MESSAGE, id)));

        Worker foundworker =getByIdWorker(id);
        foundworker.setWorkerFirstName(worker.getWorkerFirstName());
        foundworker.setWorkerLastName(worker.getWorkerLastName());
        foundworker.setWorkerType(worker.getWorkerType());
        foundworker.setWorkerAddress(worker.getWorkerAddress());
        foundworker.setWorkerSalary(worker.getWorkerSalary());
        foundworker.setCompany(company);
        workerRepository.save(foundworker);
    }


}
