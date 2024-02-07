package com.example.demo.repository;

import com.example.demo.entity.PoInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainRepository extends JpaRepository<PoInfoEntity, String> {
    boolean existsByPoMctId(String siteCd);

    PoInfoEntity findByPoMctId(String siteCd);
}
