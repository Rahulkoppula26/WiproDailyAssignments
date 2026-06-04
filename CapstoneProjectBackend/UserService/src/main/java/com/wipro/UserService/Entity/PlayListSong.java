package com.wipro.UserService.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayListSong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long songId;

    @ManyToOne
    @JoinColumn(name = "playlist_id")
    @JsonIgnore
    private PlayList playlist;
}
