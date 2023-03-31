package com.enoca.enocap.service;

import com.enoca.enocap.domain.Company;
import com.enoca.enocap.domain.Worker;
import com.enoca.enocap.exception.Message.ErrorMessage;
import com.enoca.enocap.exception.ResourceNotFoundException;
import com.enoca.enocap.repository.WorkerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {
    private static WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository) {

        this.workerRepository = workerRepository;
    }
    public void save(Worker worker){
        workerRepository.save(worker);
    }

    public List<Worker> getAllWorkers() {
        return workerRepository.findAll();
    }
    public static Worker getByIdWorker(Long id) {
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
        foundworker.setWokerLastName(worker.getWokerLastName());
        foundworker.setWorkerType(worker.getWorkerType());
        foundworker.setWorkerAddress(worker.getWorkerAddress());
        foundworker.setWorkerSalary(worker.getWorkerSalary());
        workerRepository.save(foundworker);
    }


}
