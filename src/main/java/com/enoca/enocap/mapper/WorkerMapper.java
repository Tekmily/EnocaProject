package com.enoca.enocap.mapper;

import com.enoca.enocap.domain.Company;
import com.enoca.enocap.domain.Worker;
import com.enoca.enocap.dto.WokerDTO;
import com.enoca.enocap.repository.WorkerRepository;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WorkerMapper {
WokerDTO wokerDTO(Worker worker);

Worker wokerRequsestToWorker(WorkerRepository workerRepository);

List<WokerDTO> workerListToWorkerDTOListMap(List<Worker>workerList);


}
