package com.wipro.AdminService.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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