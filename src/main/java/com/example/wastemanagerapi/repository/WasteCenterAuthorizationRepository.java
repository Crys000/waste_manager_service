package com.example.wastemanagerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.wastemanagerapi.entity.WasteCenterAuthorizationEntity;

@Repository
public interface WasteCenterAuthorizationRepository extends JpaRepository<WasteCenterAuthorizationEntity, Long> {

}
