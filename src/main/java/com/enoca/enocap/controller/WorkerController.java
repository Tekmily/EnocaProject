package com.enoca.enocap.controller;

import com.enoca.enocap.domain.Worker;
import com.enoca.enocap.dto.WorkerDTO;
import com.enoca.enocap.dto.request.WorkerRequset;
import com.enoca.enocap.dto.response.EPResponse;
import com.enoca.enocap.dto.response.ResponseMessage;
import com.enoca.enocap.mapper.WorkerMapper;
import com.enoca.enocap.service.WorkerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/worker")
public class WorkerController {
    private final WorkerService workerService;
    private final WorkerMapper workerMapper;

    public WorkerController(WorkerService workerService,
                            WorkerMapper workerMapper) {
        this.workerService = workerService;
        this.workerMapper = workerMapper;
    }
    @PostMapping("/create")
    public ResponseEntity<EPResponse> cereateWoker(
            @Valid @RequestBody WorkerRequset workerRequset){
        Worker worker = workerMapper.wokerRequsestToWorker(workerRequset);
        workerService.save(worker);
        EPResponse epResponse=new EPResponse
                ("Worker Successfully Created",true);
        return new ResponseEntity<>(epResponse, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<WorkerDTO>> getAllWorkers(){
        List<Worker> workerList=workerService.getAllWorkers();
        List<WorkerDTO> workerDTOList=workerMapper.workerListToWorkerDTOListMap(workerList);
        return ResponseEntity.ok(workerDTOList);
    }
   @GetMapping("/{id}")
   public ResponseEntity<WorkerDTO> getByIdWorker(@PathVariable("id") Long id){
        Worker worker=workerService.getByIdWorker(id);
        WorkerDTO workerDTO=workerMapper.wokerToWorkerDTO(worker);
        return ResponseEntity.ok(workerDTO);
   }
   @DeleteMapping("/{id}")
    public ResponseEntity<EPResponse> deleteByIdWorker(@PathVariable Long id) {
        workerService.deleteByIdWorker(id);
        EPResponse epResponse=new EPResponse(ResponseMessage.WORKER_DELETE_RESPONSE_MESSAGE,true);
        return ResponseEntity.ok(epResponse);
   }
   @PutMapping("/{id}")
    public ResponseEntity<EPResponse> updateByIdWorker(@PathVariable Long id,
                                                       @RequestBody WorkerRequset workerRequset){
        Worker worker=workerMapper.wokerRequsestToWorker(workerRequset);
        workerService.updateByIdWorker(id,worker);
        EPResponse epResponse=new EPResponse(ResponseMessage.WORKER_UPDATE_RESPONSE_MESSAGE,true);
        return ResponseEntity.ok(epResponse);
   }

}
