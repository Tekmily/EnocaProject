package com.enoca.enocap.service;

import com.enoca.enocap.domain.Worker;
import com.enoca.enocap.dto.WorkerDTO;
import com.enoca.enocap.exception.Message.ErrorMessage;
import com.enoca.enocap.exception.ResourceNotFoundException;
import com.enoca.enocap.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Service anotasyonu, bir sınıfın Spring Framework'teki Service katmanı bileşeni
 * olarak kullanılabileceğini belirtir.
 * @RequiredArgsConstructor anotasyonu, bir sınıfta tanımlanan final olmayan
 * tüm alanların bağımlılıklarını otomatik olarak enjekte eden bir constructor oluşturur.
 */
@Service
@RequiredArgsConstructor
public class WorkerService {
    private final WorkerRepository workerRepository;//workerRepository enjekte edildi.


    public void save(Worker worker){//SAVE company method
        workerRepository.save(worker);//Company'yi companyRepository deki jpaRepository kullanılarak kayıt işlemi yaptık
    }

    public List<WorkerDTO> getAllWorkers() {//Worker verilerin hepsini çağırma işlemi yaaptık
        List<Worker> workers = workerRepository.findAll();
        return workers.stream()
                .map(WorkerDTO::fromWorker)
                .collect(Collectors.toList());
    }
    public  Worker getByIdWorker(Long id) {//Worker verileri ID'yle çağırma işlemi yaaptık
        return workerRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException(String.format(ErrorMessage.RESOURCE_NOT_FOUND_MESSAGE, id)));//ID'yle çağrılan verilerin içerisinde istenilen ID yok ise kontrollü Exceptin fırlatması yapar
    }


    public void deleteByIdWorker(Long id) {//ID ile veritabanında silme işlemi yapar.
        Worker foundWorker =getByIdWorker(id);
        workerRepository.delete(foundWorker);

    }

    public void updateByIdWorker(Long id, Worker worker) {//ID numarası ile veritabanındaki bir veriyi Company çağrılarak bilgilerini güncelleme işlemi yapar
        Worker foundworker =getByIdWorker(id);
        foundworker.setWorkerFirstName(worker.getWorkerFirstName());
        foundworker.setWorkerLastName(worker.getWorkerLastName());
        foundworker.setWorkerType(worker.getWorkerType());
        foundworker.setWorkerAddress(worker.getWorkerAddress());
        foundworker.setWorkerSalary(worker.getWorkerSalary());
        workerRepository.save(foundworker);
    }


}
