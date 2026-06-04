package com.wipro.NotificationService.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class NotificationDto {

    private String title;
    private String message;
    private LocalDateTime createdAt;
}