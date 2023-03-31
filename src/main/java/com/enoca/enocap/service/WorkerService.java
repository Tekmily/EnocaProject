package com.enoca.enocap.service;

import com.enoca.enocap.domain.Company;
import com.enoca.enocap.domain.Worker;
import com.enoca.enocap.exception.Message.ErrorMessage;
import com.enoca.enocap.exception.ResourceNotFoundException;
import com.enoca.enocap.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkerService {
    private final WorkerRepository workerRepository;


    public void save(Worker worker){
        workerRepository.save(worker);
    }

    public List<Worker> getAllWorkers() {
        return workerRepository.findAll();
    }
    public  Worker getByIdWorker(Long id) {
        return workerRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException(String.format(ErrorMessage.RESOURCE_NOT_FOUND_MESSAGE, id)));
    }


    public void deleteByIdWorker(Long id) {
        Worker foundWorker =getByIdWorker(id);
        workerRepository.delete(foundWorker);

    }

    public void updateByIdWorker(Long id, Worker worker) {
        Worker foundworker =getByIdWorker(id);
        foundworker.setWorkerFirstName(worker.getWorkerFirstName());
        foundworker.setWorkerLastName(worker.getWorkerLastName());
        foundworker.setWorkerType(worker.getWorkerType());
        foundworker.setWorkerAddress(worker.getWorkerAddress());
        foundworker.setWorkerSalary(worker.getWorkerSalary());
        workerRepository.save(foundworker);
    }


}
