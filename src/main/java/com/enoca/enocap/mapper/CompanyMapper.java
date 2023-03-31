package com.enoca.enocap.mapper;

import com.enoca.enocap.domain.Company;
import com.enoca.enocap.dto.CompanyDTO;
import com.enoca.enocap.dto.request.CompanyRequset;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")//her hangi bir sınıf enjekte için kullanılabilir.
public interface CompanyMapper {
    CompanyDTO companyToCompanyDTO(Company company);
    @Mapping(target = "id",ignore = true)
    Company companyRequsetToCompany(CompanyRequset companyRequset);
    List<CompanyDTO> companyListToCompanyDTOListMap(List<Company>companyList);

}
