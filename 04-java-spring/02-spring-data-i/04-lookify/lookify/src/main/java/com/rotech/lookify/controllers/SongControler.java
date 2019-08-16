package com.rotech.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rotech.lookify.models.Song;
import com.rotech.lookify.services.SongService;

@Controller
@RequestMapping("/lookify")
public class SongControler {
	private final SongService songServ;
	
	public SongControler(SongService songServ) {
		this.songServ = songServ;
	}
	
	@GetMapping("")
	public String welcome(Model model) {
		return "songs/index.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model){
		List<Song> songs = songServ.getAll();
		model.addAttribute("songs", songs);
		return "songs/dashboard.jsp";
	}
	@GetMapping("/songs/{id}")
	public String getOne(@PathVariable("id") Long id, Model model) {
		Song song = songServ.getOne(id);
		model.addAttribute("song", song);
		return "songs/card.jsp";
	}
	@GetMapping("/search/{artist}")
	public String displayArtist(@PathVariable("artist") String stringartist, Model model, RedirectAttributes flash) {
		List<Song> artist = songServ.findByArtist(stringartist);
		
		if(artist.isEmpty()) {
			flash.addFlashAttribute("error","no such artist found");
			return "redirect:/lookify/dashboard";
		}
		model.addAttribute("songs", artist);
		return "songs/artist.jsp";
	}
	@GetMapping("/search/topten")
	public String displayTopTen(Model model) {
		List<Song> topTen = songServ.topTen();
		model.addAttribute("topTen", topTen);
		return "songs/TopTen.jsp";
	}
	@GetMapping("/songs/new")
	public String displayNew(@ModelAttribute("song") Song song) {
		return "songs/new.jsp";
	}
	@PostMapping("songs/new")
	public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		boolean hasErrors = result.hasErrors();
		System.out.println("new triggerd");
		if(!hasErrors) {
			System.out.println("new if triggerd");
			Song newSong = songServ.createSong(song);
			return "redirect:"+newSong.getId();
		}
		
		return "songs/new.jsp";
	}
	@PostMapping("/search")
	public String redirectArtist(@RequestParam("artist") String artist,RedirectAttributes flash) {
		if(artist.isEmpty()) {
			
			flash.addFlashAttribute("error", "artist's name must be at least 2 charaters long");
			return "redirect:/lookify/dashboard";
		}
		return "redirect:search/"+artist;
	}
	@DeleteMapping("songs/{id}")
	public String delete(@PathVariable("id") Long id) {
		songServ.deleteById(id);
		return "redirect:/lookify/dashboard";
	}
	
}
