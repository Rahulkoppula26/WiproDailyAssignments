package com.wipro.UserService.Repository;

import com.wipro.UserService.Entity.PlayListSong;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlayListSongRepository extends JpaRepository<PlayListSong, Long> {

    List<PlayListSong> findByPlaylistId(Long playlistId);

    boolean existsByPlaylistIdAndSongId(Long playlistId, Long songId);
     Optional<PlayListSong> findByPlaylistIdAndSongId(Long playlistId, Long songId);
}