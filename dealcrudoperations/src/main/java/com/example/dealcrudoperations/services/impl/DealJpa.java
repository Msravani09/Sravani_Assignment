package com.example.dealcrudoperations.services.impl;

import com.example.dealcrudoperations.dtos.DealDto;
import com.example.dealcrudoperations.entities.DealEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DealJpa {
    @Autowired
    ModelMapper modelMapper;

    public DealEntity convertDtotoDealEntity(DealDto dealDto){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        DealEntity dealentity=modelMapper.map(dealDto, DealEntity.class);
        return dealentity;
    }
    public DealDto convertDealEntityToDto(DealEntity dealEntity){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        DealDto dealDto =modelMapper.map(dealEntity,DealDto.class);
        return dealDto;
    }
}
