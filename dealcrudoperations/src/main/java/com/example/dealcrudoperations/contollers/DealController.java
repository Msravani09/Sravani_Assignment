package com.example.dealcrudoperations.contollers;

import com.example.dealcrudoperations.dtos.DealDto;
import com.example.dealcrudoperations.services.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@RestController
public class DealController {
    @Autowired
    DealService dealService;
@RequestMapping(value = "/deal", method = RequestMethod.POST)
    public ResponseEntity<DealDto> createDeal(@RequestBody DealDto dealDto){
        DealDto deal = dealService.createDeal(dealDto);
        return new ResponseEntity<DealDto>(deal,HttpStatus.OK);
    }
    @RequestMapping(value = "/deal/all", method = RequestMethod.GET)
    public ResponseEntity<List<DealDto>> getAllDeals(){
        List<DealDto> allDeals = dealService.getAllDeals();
        return new ResponseEntity<List<DealDto>>(allDeals,HttpStatus.OK);
    }
    @RequestMapping(value = "/deal/{dealNumber}", method = RequestMethod.GET)
    public ResponseEntity<DealDto> getDealByDealNumber(@PathVariable("dealNumber") String dealNumber){
        DealDto dealByDealNumber = dealService.getDealByDealNumber(dealNumber);
        if(Objects.isNull(dealByDealNumber)){
            throw new NoSuchElementException("Deal is not available with "+dealNumber);
        }
        return new ResponseEntity<DealDto>(dealByDealNumber,HttpStatus.OK);
    }
    @RequestMapping(value = "/deal/{dealNumber}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteByDealNumber(@PathVariable("dealNumber") String dealNumber){
        String message = dealService.deleteByDealNumber(dealNumber);
        return new ResponseEntity<String>(message,HttpStatus.OK);
    }

    @RequestMapping(value = "/deal/{dealNumber}", method = RequestMethod.PUT)
    public ResponseEntity<DealDto> updateDealByDealNumber(@PathVariable String dealNumber, @RequestBody DealDto dealDto) {
        DealDto updatedDealDto = dealService.updateDealByDealNumber(dealNumber, dealDto);
        return new ResponseEntity<DealDto>(updatedDealDto,HttpStatus.OK);
    }

    @RequestMapping(value = "/deal/id/{id}", method = RequestMethod.PUT)
    public ResponseEntity<DealDto> updateDealById(@PathVariable("id") Integer id, @RequestBody DealDto dealDto) {
        DealDto updatedDealDto = dealService.updateDealById(id, dealDto);
        return new ResponseEntity<DealDto>(updatedDealDto, HttpStatus.OK);
    }

}
