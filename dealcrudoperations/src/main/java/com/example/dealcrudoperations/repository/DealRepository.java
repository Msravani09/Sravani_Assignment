package com.example.dealcrudoperations.repository;

import com.example.dealcrudoperations.entities.DealEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface DealRepository extends JpaRepository<DealEntity,Integer> {
    Optional<DealEntity> findByDealNumber(String dealNumber);


}
