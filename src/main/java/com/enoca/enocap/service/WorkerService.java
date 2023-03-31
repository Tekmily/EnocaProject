package com.enoca.enocap.service;

import com.enoca.enocap.domain.Worker;
import com.enoca.enocap.repository.WorkerRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {
    private static WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }
    public void save(Worker worker){
        workerRepository.save(worker);
    }

}
