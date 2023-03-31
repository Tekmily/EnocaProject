package com.enoca.enocap.mapper;

import com.enoca.enocap.domain.Worker;
import com.enoca.enocap.dto.WorkerDTO;
import com.enoca.enocap.dto.request.WorkerRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WorkerMapper {
WorkerDTO wokerToWorkerDTO(Worker worker);

Worker wokerRequsestToWorker(WorkerRequest workerRequset);

List<WorkerDTO> workerListToWorkerDTOListMap(List<Worker>workerList);


}
