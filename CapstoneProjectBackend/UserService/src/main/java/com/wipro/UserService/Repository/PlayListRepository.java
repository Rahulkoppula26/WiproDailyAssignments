package com.wipro.UserService.Repository;

import com.wipro.UserService.Entity.PlayList;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PlayListRepository extends JpaRepository<PlayList, Long> {

    List<PlayList> findByUserId(Long userId);

    List<PlayList> findByPlaylistNameContainingIgnoreCase(String playlistName);
    boolean existsByUserIdAndPlaylistNameIgnoreCase(Long userId, String playlistName);
  
}