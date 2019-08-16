package com.rotech.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rotech.lookify.models.Song;
import com.rotech.lookify.repositories.SongRepository;

@Service
public class SongService {
	private final SongRepository songRepo;
	public SongService(SongRepository songRepo) {
		this.songRepo = songRepo;
	}
	public List<Song> getAll(){
		return songRepo.findAll();
	}
	public Song getOne(Long id) {
		Optional<Song> optSong = songRepo.findById(id);
		if(optSong.isPresent()) {
			return optSong.get();
		}else {
			return null;
		}
	}
	public Song createSong(Song song) {
		return songRepo.save(song);
	}
	public Song update(Song song) {
		return songRepo.save(song);
	}
	public void deleteById(Long id) {
		songRepo.deleteById(id);
	}
	public List<Song> findByArtist(String artist){
		List<Song> foundArtist = songRepo.findByArtist(artist);
		return foundArtist;
	}
	public List<Song> topTen(){
		return songRepo.findByOrderByRatingDesc();
	}
	
}


