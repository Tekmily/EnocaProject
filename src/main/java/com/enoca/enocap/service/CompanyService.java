package com.enoca.enocap.service;

import com.enoca.enocap.domain.Company;
import com.enoca.enocap.exception.Message.ErrorMessage;
import com.enoca.enocap.exception.ResourceNotFoundException;
import com.enoca.enocap.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    private static  CompanyRepository companyRepository;
    @Autowired
    public CompanyService(CompanyRepository companyRepository) {

        this.companyRepository = companyRepository;
    }
    public void save(Company company) {
        companyRepository.save(company);
    }

    public List<Company> getAll() {
        return companyRepository.findAll();
    }
    public static Company getCompanyById(Long id) {
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
        foundCompany.setCompanyWorker(company.getCompanyWorker());
        companyRepository.save(foundCompany);
    }
}
