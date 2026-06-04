package com.wipro.UserService.Dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class SongDto {

    private Long id;
    private String songName;
    private String artistSinger;
    private String songImageUrl;
    private String musicDirector;
    private String albumMovieName;
    private LocalDate releaseDate;
    private String songDuration;
    private boolean visibility;
    private String genre;
}