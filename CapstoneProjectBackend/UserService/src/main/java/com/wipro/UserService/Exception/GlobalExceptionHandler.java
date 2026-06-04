package com.wipro.UserService.Exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

        // This method handles ResourceNotFoundException, which is thrown when a
        // requested resource (like a user) is not found in the system. It constructs an
        // ApiResponse object with details about the error and returns it with a 404 Not
        // Found status code.
        @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<ApiResponse> handleResourceNotFound(
                        ResourceNotFoundException ex,
                        HttpServletRequest request) {

                ApiResponse response = new ApiResponse(
                                LocalDateTime.now(),
                                HttpStatus.NOT_FOUND.value(),
                                "NOT_FOUND",
                                ex.getMessage(),
                                request.getRequestURI());

                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        // This method handles DuplicateResourceException, which is thrown when an
        // attempt is made to create a resource that already exists in the system (like
        // a user with an existing email). It constructs an ApiResponse object with
        // details about the error and returns it with a 400 Bad Request status code.
        @ExceptionHandler(DuplicateResourceException.class)
        public ResponseEntity<ApiResponse> handleDuplicateResource(
                        DuplicateResourceException ex,
                        HttpServletRequest request) {

                ApiResponse response = new ApiResponse(
                                LocalDateTime.now(),
                                HttpStatus.BAD_REQUEST.value(),
                                "BAD_REQUEST",
                                ex.getMessage(),
                                request.getRequestURI());

                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        // This method handles all other exceptions that are not specifically handled by
        // the previous methods. It constructs a generic ApiResponse object with details
        // about the error and returns it with a 500 Internal Server Error status code.
        @ExceptionHandler(Exception.class)
        public ResponseEntity<ApiResponse> handleGlobalException(
                        Exception ex,
                        HttpServletRequest request) {

                ApiResponse response = new ApiResponse(
                                LocalDateTime.now(),
                                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                "INTERNAL_SERVER_ERROR",
                                ex.getMessage(),
                                request.getRequestURI());

                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
}