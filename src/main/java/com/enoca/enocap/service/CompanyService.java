package com.enoca.enocap.service;

import com.enoca.enocap.domain.Company;
import com.enoca.enocap.exception.Message.ErrorMessage;
import com.enoca.enocap.exception.ResourceNotFoundException;
import com.enoca.enocap.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @Service anotasyonu, bir sınıfın Spring Framework'teki Service katmanı bileşeni
 * olarak kullanılabileceğini belirtir.
 * @RequiredArgsConstructor anotasyonu, bir sınıfta tanımlanan final olmayan
 * tüm alanların bağımlılıklarını otomatik olarak enjekte eden bir constructor oluşturur.
 */
@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;//companyRepository enjekte edildi.

    public void save(Company company) {//SAVE company method
        companyRepository.save(company);//Company'yi companyRepository deki jpaRepository kullanılarak kayıt işlemi yaptık
    }

    public List<Company> getAll() {//Company verilerin hepsini çağırma işlemi yaaptık
        return companyRepository.findAll();
    }
    public  Company getCompanyById(Long id) {//Company verileri ID'yle çağırma işlemi yaaptık
    return companyRepository.findById(id).orElseThrow(
            ()-> new ResourceNotFoundException(String.format(ErrorMessage.RESOURCE_NOT_FOUND_MESSAGE, id)));//ID'yle çağrılan verilerin içerisinde istenilen ID yok ise kontrollü Exceptin fırlatması yapariçin
    }


    public void deleteByIdCompany(Long id) {//ID ile veritabanında silme işlemi yapar.
        Company foundCompany =getCompanyById(id);
                  companyRepository.delete(foundCompany);

    }

    public void getUpdateByIdCompany(Long id, Company company) {//ID numarası ile veritabanındaki bir veriyi Company çağrılarak bilgilerini güncelleme işlemi yapar
        Company foundCompany =getCompanyById(id);
        foundCompany.setCompanyName(company.getCompanyName());
        foundCompany.setCompanyType(company.getCompanyType());
        foundCompany.setCompanyAddress(company.getCompanyAddress());
        companyRepository.save(foundCompany);
    }
}
