package com.rotech.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rotech.lookify.models.Song;

public interface SongRepository extends CrudRepository<Song, Long> {
	List<Song> findAll();
	List<Song> findByArtist(String artist);
	List<Song> findByOrderByRatingDesc();
}
