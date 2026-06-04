package com.wipro.NotificationService.Service;

import com.wipro.NotificationService.Dto.NotificationDto;
import com.wipro.NotificationService.Dto.SongDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class NotifyService {

    private final List<NotificationDto> notifications = new ArrayList<>();

    public String sendNotification(SongDto dto) {

        NotificationDto notification = new NotificationDto(
                "New Song Available",
                dto.getSongName() + " by " + dto.getArtistSinger() + " is now available.",
                LocalDateTime.now()
        );

        notifications.add(0, notification);

        return "Notification sent successfully";
    }

    public List<NotificationDto> getNotifications() {
        return notifications;
    }
}