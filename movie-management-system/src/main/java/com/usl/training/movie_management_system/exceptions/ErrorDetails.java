package com.usl.training.movie_management_system.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.time.*;


@Getter
@Setter
public class ErrorDetails {
    private LocalDateTime timestamp;
    private String message;
    private String details;
    private String errorCode;
}
