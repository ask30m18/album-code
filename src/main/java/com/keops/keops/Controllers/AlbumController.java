package com.keops.keops.Controllers;


import com.keops.keops.model.Album;
import com.keops.keops.repository.AlbumRepository;
import com.keops.keops.repository.UserRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
public class AlbumController {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users/{userId}/albums")
    public ArrayList<Album> getAlbumsByUserId(@PathVariable Long userId) {
        return albumRepository.findByUserId(userId);
    }

    @PostMapping("/users/{userId}/albums")
    public Album addAlbum(@PathVariable Long userId,
                          @Valid @RequestBody Album album) {
        return userRepository.findById(userId)
                .map(user -> {
                    album.setUser(user);
                    return albumRepository.save(album);
                }).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
    }

    @PutMapping("/users/{userId}/albums/{albumId}")
    public Album updateAlbum(@PathVariable Long userId,
                             @PathVariable Long albumId,
                             @Valid @RequestBody Album albumRequest) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found with id " + userId);
        }

        return albumRepository.findById(albumId)
                .map(album -> {
                    album.setAlbumName(albumRequest.getAlbumName());
                    return albumRepository.save(album);
                }).orElseThrow(() -> new ResourceNotFoundException("Album not found with id " + albumId));
    }

    @DeleteMapping("/users/{userId}/albums/{albumId}")
    public ResponseEntity<?> deleteAlbum(@PathVariable Long userId,
                                         @PathVariable Long albumId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found with id " + userId);
        }

        return albumRepository.findById(albumId)
                .map(album -> {
                    albumRepository.delete(album);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Album not found with id " + albumId));
    }
}
