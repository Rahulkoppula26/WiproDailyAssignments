package com.wipro.NotificationService.Controller;

import com.wipro.NotificationService.Dto.NotificationDto;
import com.wipro.NotificationService.Dto.SongDto;
import com.wipro.NotificationService.Service.NotifyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotifyController {

    @Autowired
    private NotifyService service;

    @PostMapping("/send")
    public String sendNotification(@RequestBody SongDto dto) {
        return service.sendNotification(dto);
    }

    @GetMapping
    public List<NotificationDto> getNotifications() {
        return service.getNotifications();
    }
}