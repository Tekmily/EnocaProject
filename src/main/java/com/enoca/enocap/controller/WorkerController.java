package com.enoca.enocap.controller;

import com.enoca.enocap.domain.Company;
import com.enoca.enocap.domain.Worker;
import com.enoca.enocap.dto.WorkerDTO;
import com.enoca.enocap.dto.request.WorkerRequest;
import com.enoca.enocap.dto.response.EPResponse;
import com.enoca.enocap.dto.response.ResponseMessage;
import com.enoca.enocap.mapper.WorkerMapper;
import com.enoca.enocap.repository.WorkerRepository;
import com.enoca.enocap.service.CompanyService;
import com.enoca.enocap.service.WorkerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/worker")
public class WorkerController {

    private final WorkerService workerService;
    private final CompanyService companyService;
    private final WorkerMapper workerMapper;
    private final WorkerRepository workerRepository;

            //http://localhost:8082/company/create
    @PostMapping("/create")
    public ResponseEntity<EPResponse> createWorker(
            @Valid @RequestBody WorkerRequest workerRequest){
        Worker worker = workerMapper.wokerRequsestToWorker(workerRequest);
        Company company=companyService.getCompanyById(workerRequest.getCompanyId());
        worker.setCompany(company);
        workerService.save(worker);
        company.getWorkersList().add(worker);
        companyService.save(company);
        EPResponse epResponse=new EPResponse
                ("Worker Successfully Created",true);
        return new ResponseEntity<>(epResponse, HttpStatus.CREATED);
    }
            //http://localhost:8082/company
    @GetMapping
    public ResponseEntity<List<WorkerDTO>> getAllWorkers(){
        List<WorkerDTO> workerList=workerService.getAllWorkers();
        return new ResponseEntity<>(workerList, HttpStatus.OK);
    }
    //http://localhost:8082/company/3

   @GetMapping("/{id}")
   public ResponseEntity<WorkerDTO> getByIdWorker(@PathVariable Long id){
        Worker worker=workerService.getByIdWorker(id);
       WorkerDTO workerDTO = WorkerDTO.fromWorker(worker);
        return ResponseEntity.ok().body(workerDTO);
   }
   //http://localhost:8082/company/4
   @DeleteMapping("/{id}")
    public ResponseEntity<EPResponse> deleteByIdWorker(@PathVariable Long id) {
        EPResponse epResponse=new EPResponse(ResponseMessage.WORKER_DELETE_RESPONSE_MESSAGE,true);
        return ResponseEntity.ok(epResponse);
   }
   //http://localhost:8082/company/3
   @PutMapping("/{id}")
    public ResponseEntity<EPResponse> updateByIdWorker(@PathVariable Long id,
                                                       @RequestBody WorkerRequest workerRequest){
        Worker worker=workerMapper.wokerRequsestToWorker(workerRequest);
        workerService.updateByIdWorker(id,worker);
        EPResponse epResponse=new EPResponse(ResponseMessage.WORKER_UPDATE_RESPONSE_MESSAGE,true);
        return ResponseEntity.ok(epResponse);
   }


}
