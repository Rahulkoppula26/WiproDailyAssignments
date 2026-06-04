package com.wipro.AdminService.Controller;

import com.wipro.AdminService.Entity.Song;
import com.wipro.AdminService.Service.SongService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/admin/songs")
public class SongController {

    @Autowired
    private SongService service;
// This method handles POST requests to add a new song. 
    @PostMapping
    public ResponseEntity<?> addSong(@RequestBody Song song) {

        Song savedSong = service.addSong(song);

        return new ResponseEntity<>(savedSong, HttpStatus.CREATED);
    }
// This method handles GET requests to retrieve all songs. 
    @GetMapping
    public ResponseEntity<List<Song>> getAllSongs() {

        return ResponseEntity.ok(service.getAllSongs());
    }
// This method handles GET requests to retrieve a song by its ID. It returns the song if found, or a 404 error if not found.
    @GetMapping("/{id}")
    public ResponseEntity<?> getSong(@PathVariable Long id) {

        try {
            return ResponseEntity.ok(service.getSong(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
// This method handles PUT requests to update an existing song by its ID. 
    @PutMapping("/{id}")
    public ResponseEntity<?> updateSong(
            @PathVariable Long id,
            @RequestBody Song song) {

        try {
            Song updatedSong = service.updateSong(id, song);

            return ResponseEntity.ok(updatedSong);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
// This method handles DELETE requests to delete a song by its ID. 
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSong(@PathVariable Long id) {

        try {

            service.deleteSong(id);

            return ResponseEntity.ok("Song Deleted Successfully");
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
// This method handles GET requests to retrieve all visible songs. It returns a list of songs that are marked as visible in the system.
    @GetMapping("/visible")
    public ResponseEntity<List<Song>> getVisibleSongs() {

        return ResponseEntity.ok(service.getVisibleSongs());
    }
// This method handles GET requests to retrieve songs by their album or movie name. It returns a list of songs that belong to the specified album or movie.
    @GetMapping("/album/{albumMovieName}")
    public ResponseEntity<List<Song>> getSongsByAlbum(
            @PathVariable String albumMovieName) {

        return ResponseEntity.ok(
                service.getSongsByAlbum(albumMovieName));
    }
// This method handles GET requests to retrieve songs by their singer or artist name. It returns a list of songs that are performed by the specified singer or artist.
    @GetMapping("/singer/{artistSinger}")
    public ResponseEntity<List<Song>> getSongsBySinger(
            @PathVariable String artistSinger) {

        return ResponseEntity.ok(
                service.getSongsBySinger(artistSinger));
    }

    // This method handles GET requests to retrieve songs by their music director's name. 
    @GetMapping("/musicdirector/{director}")
    public ResponseEntity<List<Song>> getSongsByMusicDirector(
            @PathVariable String director) {

        return ResponseEntity.ok(
                service.getSongsByMusicDirector(director));
    }

// This method handles GET requests to retrieve songs by their genre. It returns a list of songs that belong to the specified genre.
    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Song>> getSongsByGenre(
            @PathVariable String genre) {

        return ResponseEntity.ok(
                service.getSongsByGenre(genre));
    }
// This method handles GET requests to search for songs by their name. 
    @GetMapping("/search/name/{songName}")
    public ResponseEntity<List<Song>> searchSongsByName(@PathVariable String songName) {
        return ResponseEntity.ok(service.searchSongsByName(songName));
    }
}