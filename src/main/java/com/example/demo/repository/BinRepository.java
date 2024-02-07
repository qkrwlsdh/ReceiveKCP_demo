package com.example.demo.repository;

import com.example.demo.entity.BinEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BinRepository extends JpaRepository<BinEntity, String> {
    boolean existsByBinNo(String cardNo);
}
