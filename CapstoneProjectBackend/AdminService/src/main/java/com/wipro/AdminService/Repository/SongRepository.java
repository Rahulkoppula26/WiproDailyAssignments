package com.wipro.AdminService.Repository;

import com.wipro.AdminService.Entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {

    List<Song> findByVisibilityTrue();

    List<Song> findByAlbumMovieName(String albumMovieName);

    List<Song> findByArtistSinger(String artistSinger);

    List<Song> findByMusicDirector(String musicDirector);

    List<Song> findByGenre(String genre);
    
    List<Song> findBySongNameContainingIgnoreCase(String songName);
}