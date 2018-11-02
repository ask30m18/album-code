package com.keops.keops.repository;

import com.keops.keops.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    ArrayList<Album> findByUserId(Long userId);
}
