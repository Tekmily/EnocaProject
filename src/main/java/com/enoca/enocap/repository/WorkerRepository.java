package com.enoca.enocap.repository;

import com.enoca.enocap.domain.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker,Long> {
    //JpaRepository ile  Entity sınıfları için
// CRUD (Create, Read, Update, Delete) işlemlerini sağlar.
// Bu sayede, veritabanı işlemleri için gereksinim duyulan
// kod miktarını azaltır ve yazılım geliştirme sürecini hızlandırır.
}
