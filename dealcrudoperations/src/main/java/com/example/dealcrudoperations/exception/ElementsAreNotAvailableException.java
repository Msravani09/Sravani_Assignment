package com.example.dealcrudoperations.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElementsAreNotAvailableException extends RuntimeException {
    private String message;

}
