package com.example.dealcrudoperations.services;

import com.example.dealcrudoperations.dtos.DealDto;
import java.util.List;

public interface DealService {
    public DealDto createDeal(DealDto deal);

    public List<DealDto> getAllDeals();

    public DealDto getDealByDealNumber(String dealNumber);

    public String deleteByDealNumber(String dealNumber);

    public DealDto updateDealByDealNumber(String dealNumber, DealDto deal);

    public DealDto updateDealById(Integer Id, DealDto deal);

}
