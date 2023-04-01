package com.enoca.enocap.repository;

import com.enoca.enocap.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository <Company,Long> {
//JpaRepository ile  Entity sınıfları için
// CRUD (Create, Read, Update, Delete) işlemlerini sağlar.
// Bu sayede, veritabanı işlemleri için gereksinim duyulan
// kod miktarını azaltır ve yazılım geliştirme sürecini hızlandırır.
}
