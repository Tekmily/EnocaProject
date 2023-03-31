package com.enoca.enocap.controller;

import com.enoca.enocap.domain.Company;
import com.enoca.enocap.dto.CompanyDTO;
import com.enoca.enocap.dto.request.CompanyRequset;
import com.enoca.enocap.dto.response.EPResponse;
import com.enoca.enocap.dto.response.ResponseMessage;
import com.enoca.enocap.mapper.CompanyMapper;
import com.enoca.enocap.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;
    private final CompanyMapper companyMapper;
    @Autowired
    public CompanyController(CompanyService companyService, CompanyMapper companyMapper) {
        this.companyService = companyService;
        this.companyMapper = companyMapper;
    }
    @PostMapping("/create")
    public ResponseEntity<EPResponse> createCompany(@Valid @RequestBody CompanyRequset companyRequset){
        Company company=companyMapper.companyRequsetToCompany(companyRequset);
        companyService.save(company);
        EPResponse epResponse=new EPResponse("Company successfully created",true);
        return new ResponseEntity<>(epResponse, HttpStatus.CREATED);

    }
    @GetMapping
    public ResponseEntity<List<CompanyDTO>> getAllCompany(){
       List<Company> companyList= companyService.getAll();
       //mapStruct
        List<CompanyDTO> companyDTOList=companyMapper.companyListToCompanyDTOListMap(companyList);
        return ResponseEntity.ok(companyDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDTO> getByIdCompany(@PathVariable("id")Long id) {
        Company company=CompanyService.getCompanyById(id);
        CompanyDTO companyDTOList=companyMapper.companyToCompanyDTO(company);
        return ResponseEntity.ok(companyDTOList);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<EPResponse> getDeleteByIdCompany(@PathVariable Long id) {
        companyService.deleteByIdCompany(id);
        EPResponse epResponse=new EPResponse(ResponseMessage.COMPANY_DELETE_RESPONSE_MESSAGE,true);
        return ResponseEntity.ok(epResponse);
    }
    @PutMapping("/{id}")
    public ResponseEntity<EPResponse> getUpdateByIdCompany(@PathVariable Long id,
                                                           @RequestBody CompanyRequset companyRequset){
        Company company= companyMapper.companyRequsetToCompany(companyRequset);
        companyService.getUpdateByIdCompany(id, company);
        EPResponse epResponse=new EPResponse(ResponseMessage.COMPANY_UPDATE_RESPONSE_MESSAGE,true);
        return  ResponseEntity.ok(epResponse);
    }


}
