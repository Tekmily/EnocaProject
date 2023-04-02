package com.enoca.enocap.service;

import com.enoca.enocap.domain.Company;
import com.enoca.enocap.exception.Message.ErrorMessage;
import com.enoca.enocap.exception.ResourceNotFoundException;
import com.enoca.enocap.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public void save(Company company) {
        companyRepository.save(company);
    }

    public List<Company> getAll() {//Company verilerin hepsini çağırma işlemi yaaptık
        return companyRepository.findAll();
    }
    public  Company getCompanyById(Long id) {
    return companyRepository.findById(id).orElseThrow(
            ()-> new ResourceNotFoundException(String.format(ErrorMessage.RESOURCE_NOT_FOUND_MESSAGE, id)));
    }


    public void deleteByIdCompany(Long id) {
        Company foundCompany =getCompanyById(id);
                  companyRepository.delete(foundCompany);

    }

    public void getUpdateByIdCompany(Long id, Company company) {
        Company foundCompany =getCompanyById(id);
        foundCompany.setCompanyName(company.getCompanyName());
        foundCompany.setCompanyType(company.getCompanyType());
        foundCompany.setCompanyAddress(company.getCompanyAddress());
        companyRepository.save(foundCompany);
    }
}
