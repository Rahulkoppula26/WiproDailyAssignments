package com.wipro.NotificationService.Dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class SongDto {

    private Long id;
    private String songName;
    private String artistSinger;
    private String musicDirector;
    private String albumMovieName;
    private LocalDate releaseDate;
    private boolean visibility;
}