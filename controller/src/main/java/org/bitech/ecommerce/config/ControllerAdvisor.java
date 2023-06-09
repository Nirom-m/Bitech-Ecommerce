package org.bitech.ecommerce.config;

import org.bitech.ecommerce.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.bitech.ecommerce.config.Constants.*;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex) {
        List<String> errorMessages = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            if (error instanceof FieldError) {
                FieldError fieldError = (FieldError) error;
                errorMessages.add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
            } else {
                errorMessages.add(error.getDefaultMessage());
            }
        }
        return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleAuthenticationException(ProductNotFoundException productNotFoundException) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, PRODUCT_NOT_FOUND_EXCEPTION_MESSAGE));
    }

    @ExceptionHandler(ProductsNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleAuthenticationException(ProductsNotFoundException productsNotFoundException) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, PRODUCTS_NOT_FOUND_EXCEPTION_MESSAGE));
    }
    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleAuthenticationException(ClientNotFoundException clientNotFoundException) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, CLIENT_NOT_FOUND_EXCEPTION_MESSAGE));
    }

    @ExceptionHandler(NegativeAmountProductException.class)
    public ResponseEntity<Map<String, String>> handleAuthenticationException(NegativeAmountProductException negativeAmountProductException) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, NEGATIVE_AMOUNT_PRODUCT_EXCEPTION_MESSAGE));
    }
    @ExceptionHandler(ClientNotHaveShoppingCartException.class)
    public ResponseEntity<Map<String, String>> handleAuthenticationException(ClientNotHaveShoppingCartException clientNotHaveShoppingCartException) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, CLIENT_NOT_HAVE_SHOPPING_CART_EXCEPTION_MESSAGE));
    }
}
