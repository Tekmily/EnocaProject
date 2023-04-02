package com.enoca.enocap.repository;

import com.enoca.enocap.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository <Company,Long> {

}
