package com.example.wastemanagerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.wastemanagerapi.entity.WasteManagerEntity;

@Repository
public interface WasteManagerRepository extends JpaRepository<WasteManagerEntity, Long> {

}
