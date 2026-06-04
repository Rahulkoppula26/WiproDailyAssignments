
package com.wipro.UserService.Service;

import com.wipro.UserService.Dto.PlaylistResponseDto;
import com.wipro.UserService.Dto.SongDto;
import com.wipro.UserService.Entity.PlayList;
import com.wipro.UserService.Entity.PlayListSong;
import com.wipro.UserService.Exception.DuplicateResourceException;
import com.wipro.UserService.Exception.ResourceNotFoundException;
import com.wipro.UserService.Repository.PlayListRepository;
import com.wipro.UserService.Repository.PlayListSongRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PlayListService {

    @Autowired
    private PlayListRepository repository;

    @Autowired
    private PlayListSongRepository playListSongRepository;

    @Autowired
    private RestTemplate restTemplate;
// This method creates a new playlist. 

    public PlayList createPlaylist(PlayList playlist) {
        boolean exists = repository.existsByUserIdAndPlaylistNameIgnoreCase(
                playlist.getUserId(),
                playlist.getPlaylistName());
        if (exists) {
            throw new DuplicateResourceException("Playlist name already exists");
        }

        if (playlist.getSongs() != null) {
            playlist.getSongs().forEach(song -> song.setPlaylist(playlist));
        }

        return repository.save(playlist);
    }
// This method retrieves all playlists from the repository. 
    public List<PlayList> getAllPlaylists() {
        return repository.findAll();
    }

    public List<PlayList> getPlaylistsByUser(Long userId) {
        return repository.findByUserId(userId);
    }
// This method retrieves a specific playlist by its ID. It also fetches the songs in the playlist by making REST calls to the AdminService to get song details, and returns a PlaylistResponseDto containing the playlist information and its songs.
    public PlaylistResponseDto getPlaylist(Long playlistId) {

        PlayList playlist = repository.findById(playlistId)
                .orElseThrow(() -> new ResourceNotFoundException("Playlist not found with id: " + playlistId));

        PlaylistResponseDto response = new PlaylistResponseDto();
        response.setId(playlist.getId());
        response.setPlaylistName(playlist.getPlaylistName());
        response.setUserId(playlist.getUserId());

        List<SongDto> songs = playlist.getSongs()
                .stream()
                .map(playListSong -> restTemplate.getForObject(
                        "http://ADMINSERVICE/admin/songs/" + playListSong.getSongId(),
                        SongDto.class))
                .toList();

        response.setSongs(songs);
        return response;
    }

    // This method updates an existing playlist by its ID. 
    public PlayList updatePlaylist(Long id, PlayList updatedPlaylist) {

        PlayList existingPlaylist = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Playlist not found with id: " + id));

        existingPlaylist.setPlaylistName(updatedPlaylist.getPlaylistName());
        existingPlaylist.setUserId(updatedPlaylist.getUserId());
        existingPlaylist.setVisibility(updatedPlaylist.isVisibility());

        return repository.save(existingPlaylist);
    }
// This method deletes a playlist by its ID.  
    public void deletePlaylist(Long id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Playlist not found with id: " + id);
        }

        repository.deleteById(id);
    }

// This method adds a song to a playlist.
    public PlayListSong addSongToPlaylist(Long playlistId, Long songId) {

        PlayList playlist = repository.findById(playlistId)
                .orElseThrow(() -> new ResourceNotFoundException("Playlist not found with id: " + playlistId));

        if (playListSongRepository.existsByPlaylistIdAndSongId(playlistId, songId)) {
            throw new DuplicateResourceException("Song already exists in playlist");
        }

        PlayListSong playListSong = new PlayListSong();
        playListSong.setSongId(songId);
        playListSong.setPlaylist(playlist);

        return playListSongRepository.save(playListSong);
    }

    // This method removes a song from a playlist. 

    public void removeSongFromPlaylist(Long playlistId, Long songId) {

        repository.findById(playlistId)
                .orElseThrow(() -> new ResourceNotFoundException("Playlist not found"));

        PlayListSong playlistSong = playListSongRepository
                .findByPlaylistIdAndSongId(playlistId, songId)
                .orElseThrow(() -> new ResourceNotFoundException("Song not found in playlist"));

        playListSongRepository.delete(playlistSong);
    }

    public List<PlayList> searchPlaylistByName(String playlistName) {
        return repository.findByPlaylistNameContainingIgnoreCase(playlistName);
    }


    public SongDto[] searchSongsByName(String name) {
        return restTemplate.getForObject(
                "http://ADMINSERVICE/admin/songs/search/name/" + name,
                SongDto[].class);
    }


    public SongDto[] searchSongsByArtist(String artist) {
        return restTemplate.getForObject(
                "http://ADMINSERVICE/admin/songs/singer/" + artist,
                SongDto[].class);
    }


    public SongDto[] searchSongsByAlbum(String album) {
        return restTemplate.getForObject(
                "http://ADMINSERVICE/admin/songs/album/" + album,
                SongDto[].class);
    }


    public SongDto[] searchSongsByMusicDirector(String director) {
        return restTemplate.getForObject(
                "http://ADMINSERVICE/admin/songs/musicdirector/" + director,
                SongDto[].class);
    }
}