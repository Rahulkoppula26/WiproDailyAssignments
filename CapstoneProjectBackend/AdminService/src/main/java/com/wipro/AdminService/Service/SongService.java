package com.wipro.AdminService.Service;

//
import com.wipro.AdminService.Entity.Song;
import com.wipro.AdminService.Exception.ResourceNotFoundException;
import com.wipro.AdminService.Repository.SongRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class SongService {

    @Autowired
    private SongRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    // Method to add a new song and send a notification to the notification service
    public Song addSong(Song song) {

        Song savedSong = repository.save(song);

        if (savedSong.isVisibility()) {
            try {
                restTemplate.postForObject(
                        "http://NOTIFICATIONSERVICE/notifications/send",
                        savedSong,
                        String.class);
            } catch (Exception e) {
                System.out.println("Notification service not available");
            }
        }

        return savedSong;
    }

    // Method to retrieve all songs
    public List<Song> getAllSongs() {
        return repository.findAll();
    }

    // Method to retrieve a song by its ID
    public Song getSong(Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Song not found with id : " + id));
    }

    // Method to update an existing song by its ID and send a notification if the
    // song's visibility changes from hidden to visible
    public Song updateSong(Long id, Song updatedSong) {

        Song existingSong = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Song not found with id: " + id));

        boolean wasHidden = !existingSong.isVisibility();

        existingSong.setSongName(updatedSong.getSongName());
        existingSong.setArtistSinger(updatedSong.getArtistSinger());
        existingSong.setSongImageUrl(updatedSong.getSongImageUrl());
        existingSong.setMusicDirector(updatedSong.getMusicDirector());
        existingSong.setAlbumMovieName(updatedSong.getAlbumMovieName());
        existingSong.setReleaseDate(updatedSong.getReleaseDate());
        existingSong.setSongDuration(updatedSong.getSongDuration());
        existingSong.setVisibility(updatedSong.isVisibility());
        existingSong.setGenre(updatedSong.getGenre());

        Song savedSong = repository.save(existingSong);

        boolean nowVisible = savedSong.isVisibility();

        if (wasHidden && nowVisible) {
            try {
                restTemplate.postForObject(
                        "http://NOTIFICATIONSERVICE/notifications/send",
                        savedSong,
                        String.class);
            } catch (Exception e) {
                System.out.println("Notification service not available");
            }
        }

        return savedSong;
    }
// Method to delete a song by its ID. It checks if the song exists before attempting to delete it, and throws a ResourceNotFoundException if the song is not found.
    public void deleteSong(Long id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Song not found with id : " + id);
        }

        repository.deleteById(id);
    }
    

    public List<Song> getVisibleSongs() {
        return repository.findByVisibilityTrue();
    }

    public List<Song> getSongsByAlbum(String albumMovieName) {
        return repository.findByAlbumMovieName(albumMovieName);
    }

    public List<Song> getSongsBySinger(String artistSinger) {
        return repository.findByArtistSinger(artistSinger);
    }

    public List<Song> getSongsByMusicDirector(String director) {
        return repository.findByMusicDirector(director);
    }

    public List<Song> getSongsByGenre(String genre) {
        return repository.findByGenre(genre);
    }

    public List<Song> searchSongsByName(String songName) {
        return repository.findBySongNameContainingIgnoreCase(songName);
    }
}