package com.example.dealcrudoperations.advice;

import com.example.dealcrudoperations.exception.AllReadyExistedException;
import com.example.dealcrudoperations.exception.ElementsAreNotAvailableException;
import com.example.dealcrudoperations.exception.InvalidInputException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.NoSuchElementException;

@ControllerAdvice
public class MyController {
    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<String> handleInvalidInput(InvalidInputException invalidInput){
        return new ResponseEntity<String>(invalidInput.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ElementsAreNotAvailableException.class)
    public ResponseEntity<String> handelElementsAreNotAvailable(ElementsAreNotAvailableException elementsAreNotAvailable){
        return new ResponseEntity<>(elementsAreNotAvailable.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AllReadyExistedException.class)
    public ResponseEntity<String> handelAllReadyExisted(AllReadyExistedException allReadyExistedExpection){
        return new ResponseEntity<String>(allReadyExistedExpection.getMessage(),HttpStatus.ALREADY_REPORTED);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handelNoSuchElemetsException(NoSuchElementException exception){
        return new ResponseEntity<>( exception.getMessage(),HttpStatus.NOT_FOUND);
    }

}
