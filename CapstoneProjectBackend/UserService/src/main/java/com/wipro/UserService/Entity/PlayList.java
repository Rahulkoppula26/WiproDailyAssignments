package com.wipro.UserService.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String playlistName;

    private Long userId;

    private boolean visibility;

    @OneToMany(mappedBy = "playlist", cascade = CascadeType.ALL)
    private List<PlayListSong> songs;
}