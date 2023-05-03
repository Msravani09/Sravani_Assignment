package com.example.dealcrudoperations.services.impl;

import com.example.dealcrudoperations.dtos.DealDto;
import com.example.dealcrudoperations.entities.DealEntity;
import com.example.dealcrudoperations.exception.AllReadyExistedException;
import com.example.dealcrudoperations.repository.DealRepository;
import com.example.dealcrudoperations.services.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class DealImpl implements DealService {
    @Autowired
    DealRepository dealRepository;
    @Autowired
    DealJpa dealJpa;

    @Override
    public DealDto createDeal(DealDto dealDto) {
        Optional<DealEntity> existingDealEntity = dealRepository.findByDealNumber(dealDto.getDealNumber());
        if (existingDealEntity.isPresent()) {
            throw new AllReadyExistedException("Deal with deal number " + dealDto.getDealNumber() + " already exists.");
        }

        DealEntity dealEntity = dealJpa.convertDtotoDealEntity(dealDto);
        DealEntity savedDealEntity = dealRepository.save(dealEntity);

        return dealJpa.convertDealEntityToDto(savedDealEntity);
    }

    @Override
    public List<DealDto> getAllDeals() {
        List<DealEntity> dealEntity = dealRepository.findAll();
        if (dealEntity.isEmpty()) {
            throw new NoSuchElementException("Deals are not Available in DB...");
        }
        List<DealDto> dealDtos = new ArrayList<>();
        for (DealEntity dealEntity1 : dealEntity) {
            DealDto dealDto = dealJpa.convertDealEntityToDto(dealEntity1);
            dealDtos.add(dealDto);
        }
        return dealDtos;
    }

    @Override
    public DealDto getDealByDealNumber(String dealNumber) {
        DealEntity dealEntity = dealRepository.findByDealNumber(dealNumber).orElse(null);
        if (Objects.isNull(dealEntity)) {
            throw new NoSuchElementException("No deal found with deal number " + dealNumber);
        }
        DealDto dealDto = dealJpa.convertDealEntityToDto(dealEntity);
        return dealDto;
    }

    @Override
    public String deleteByDealNumber(String dealNumber) {
        Optional<DealEntity> dealEntityOptional = dealRepository.findByDealNumber(dealNumber);
        if (dealEntityOptional.isPresent()) {
            DealEntity dealEntity = dealEntityOptional.get();
            dealRepository.delete(dealEntity);
            return "Deal with deal number: " + dealNumber + " deleted successfully.";
        } else {
            throw new NoSuchElementException("Deal not found with deal number: " + dealNumber);
        }
    }

        @Override
        public DealDto updateDealByDealNumber(String dealNumber, DealDto dealDto){
            Optional<DealEntity> dealEntity = dealRepository.findByDealNumber(dealNumber);
            if (dealEntity.isEmpty()) {
                throw new NoSuchElementException("Deal is not Available in DB...");
            }
            DealEntity updatedDealEntity = dealJpa.convertDtotoDealEntity(dealDto);
            updatedDealEntity.setId(dealEntity.get().getId());

            DealEntity savedDealEntity = dealRepository.save(updatedDealEntity);
            DealDto savedDealDto = dealJpa.convertDealEntityToDto(savedDealEntity);

            return savedDealDto;

        }
        @Override
        public DealDto updateDealById(Integer id, DealDto dealDto) {
            Optional<DealEntity> dealEntityOptional = dealRepository.findById(id);
            if (dealEntityOptional.isPresent()) {
                DealEntity existingDealEntity = dealEntityOptional.get();
                DealEntity updatedDealEntity = dealJpa.convertDtotoDealEntity(dealDto);
                updatedDealEntity.setId(existingDealEntity.getId());
                updatedDealEntity.setDealNumber(existingDealEntity.getDealNumber());
                DealEntity savedDealEntity = dealRepository.save(updatedDealEntity);
                return dealJpa.convertDealEntityToDto(savedDealEntity);
            } else {
                throw new NoSuchElementException("Deal not found with id: " + id);
            }
        }

    }







