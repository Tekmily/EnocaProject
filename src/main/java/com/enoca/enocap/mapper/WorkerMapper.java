package com.enoca.enocap.mapper;

import com.enoca.enocap.domain.Worker;
import com.enoca.enocap.dto.WorkerDTO;
import com.enoca.enocap.dto.request.WorkerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
//@Mapper: Bu anahtar kelime, MapStruct kütüphanesi tarafından kullanılan bir sınıfın,
// diğer sınıflarla nasıl eşleştirileceğini belirlemek için kullanılır.
// u işlem, sınıf içindeki özelliklerin birbirleriyle eşleştirilmesini sağlayarak
// veri dönüşümünü kolaylaştırır.
@Mapper(componentModel = "spring")//her hangi bir sınıf enjekte için kullanılabilir.
public interface WorkerMapper {
WorkerDTO wokerToWorkerDTO(Worker worker);//Worker Entity deki verileri WorkerDTo dönüştürür.
    //@Mapping: Bu anahtar kelime, MapStruct kütüphanesi tarafından kullanılan bir sınıfın,
    // diğer sınıflarla nasıl eşleştirileceğinde belirli bir özellik için özel bir dönüşüm
    // kuralları belirlemek için kullanılır. Bu işlem, özellikler arasındaki veri dönüşümünü
    // kontrol etmek için kullanılabilir.
@Mapping(target = "id",ignore = true)//@Mapping(target = "id", ignore = true) ifadesi, kaynak nesnede "id" adlı bir özellik olsa bile, dönüşüm sırasında hedef nesneye atanmayacağını belirtir.
Worker wokerRequsestToWorker(WorkerRequest workerRequset);//workerRequset'ti Worker ye dönüştürür.

List<WorkerDTO> workerListToWorkerDTOListMap(List<Worker>workerList);//workerList'ti WorkerDTOList'e dönüştürür.


}
