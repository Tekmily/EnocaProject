package com.enoca.enocap.mapper;

import com.enoca.enocap.domain.Company;
import com.enoca.enocap.dto.CompanyDTO;
import com.enoca.enocap.dto.request.CompanyRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
//@Mapper: Bu anahtar kelime, MapStruct kütüphanesi tarafından kullanılan bir sınıfın,
// diğer sınıflarla nasıl eşleştirileceğini belirlemek için kullanılır.
// u işlem, sınıf içindeki özelliklerin birbirleriyle eşleştirilmesini sağlayarak
// veri dönüşümünü kolaylaştırır.
@Mapper(componentModel = "spring")//her hangi bir sınıf enjekte için kullanılabilir.
public interface CompanyMapper {
    CompanyDTO companyToCompanyDTO(Company company);//Company Entity deki verileri CompanyDTo dönüştürür.
    //@Mapping: Bu anahtar kelime, MapStruct kütüphanesi tarafından kullanılan bir sınıfın,
    // diğer sınıflarla nasıl eşleştirileceğinde belirli bir özellik için özel bir dönüşüm
    // kuralları belirlemek için kullanılır. Bu işlem, özellikler arasındaki veri dönüşümünü
    // kontrol etmek için kullanılabilir.
    @Mapping(target = "id",ignore = true)//@Mapping(target = "id", ignore = true) ifadesi, kaynak nesnede "id" adlı bir özellik olsa bile, dönüşüm sırasında hedef nesneye atanmayacağını belirtir.
    Company companyRequsetToCompany(CompanyRequest companyRequset);//companyRequset'ti Compant ye dönüştürür.
    List<CompanyDTO> companyListToCompanyDTOListMap(List<Company>companyList);//companyList'ti CompanyDTOList'e dönüştürür.

}
