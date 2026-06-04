
package com.wipro.UserService.Controller;

import com.wipro.UserService.Dto.PlaylistResponseDto;
import com.wipro.UserService.Dto.SongDto;
import com.wipro.UserService.Entity.PlayList;
import com.wipro.UserService.Entity.PlayListSong;
import com.wipro.UserService.Service.PlayListService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/playlists")
@RequiredArgsConstructor
public class PlayListController {

    private final PlayListService service;

    @PostMapping
    public ResponseEntity<PlayList> createPlaylist(@RequestBody PlayList playlist) {
        return new ResponseEntity<>(service.createPlaylist(playlist), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PlayList>> getAllPlaylists() {
        return ResponseEntity.ok(service.getAllPlaylists());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PlayList>> getPlaylistsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getPlaylistsByUser(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlaylistResponseDto> getPlaylist(@PathVariable Long id) {
        return ResponseEntity.ok(service.getPlaylist(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayList> updatePlaylist(
            @PathVariable Long id,
            @RequestBody PlayList playlist) {

        return ResponseEntity.ok(service.updatePlaylist(id, playlist));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlaylist(@PathVariable Long id) {
        service.deletePlaylist(id);
        return ResponseEntity.ok("Playlist Deleted Successfully");
    }

    @PostMapping("/{playlistId}/songs/{songId}")
    public ResponseEntity<PlayListSong> addSongToPlaylist(
            @PathVariable Long playlistId,
            @PathVariable Long songId) {

        return new ResponseEntity<>(
                service.addSongToPlaylist(playlistId, songId),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{playlistId}/songs/{songId}")
    public ResponseEntity<String> removeSongFromPlaylist(
            @PathVariable Long playlistId,
            @PathVariable Long songId) {

        service.removeSongFromPlaylist(playlistId, songId);
        return ResponseEntity.ok("Song removed from playlist successfully");
    }

    @GetMapping("/search/{playlistName}")
    public ResponseEntity<List<PlayList>> searchPlaylistByName(
            @PathVariable String playlistName) {

        return ResponseEntity.ok(service.searchPlaylistByName(playlistName));
    }

    @GetMapping("/songs/search/name/{name}")
    public ResponseEntity<SongDto[]> searchSongsByName(@PathVariable String name) {
        return ResponseEntity.ok(service.searchSongsByName(name));
    }

    @GetMapping("/songs/search/artist/{artist}")
    public ResponseEntity<SongDto[]> searchSongsByArtist(@PathVariable String artist) {
        return ResponseEntity.ok(service.searchSongsByArtist(artist));
    }

    @GetMapping("/songs/search/album/{album}")
    public ResponseEntity<SongDto[]> searchSongsByAlbum(@PathVariable String album) {
        return ResponseEntity.ok(service.searchSongsByAlbum(album));
    }

    @GetMapping("/songs/search/musicdirector/{director}")
    public ResponseEntity<SongDto[]> searchSongsByMusicDirector(@PathVariable String director) {
        return ResponseEntity.ok(service.searchSongsByMusicDirector(director));
    }
}