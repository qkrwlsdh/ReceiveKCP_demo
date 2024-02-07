package com.example.demo.repository;

import com.example.demo.entity.TransEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface TransRepository extends JpaRepository<TransEntity, String> {
    boolean existsByTransId(String tno);

    boolean existsByPoMctIdAndCardNoAndTransDtAndTransAmt(String siteCd, String cardNo, LocalDateTime appTime, double amount);
}
