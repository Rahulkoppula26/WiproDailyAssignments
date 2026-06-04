package com.wipro.UserService.Dto;

import lombok.Data;
import java.util.List;

@Data
public class PlaylistResponseDto {

    private Long id;
    private String playlistName;
    private Long userId;

    private List<SongDto> songs;
}