package com.rotech.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rotech.languages.models.Language;
import com.rotech.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private LanguageRepository langRepo;
	
	public LanguageService (LanguageRepository langRepo) {
		this.langRepo = langRepo;
	}
	public List<Language> allLanguages(){
		return langRepo.findAll();
	}
	public Language findOne(Long id) {
		Optional<Language> optionalLanguage = langRepo.findById(id);
		if(optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		}else {
			return null;
		}
	}
	public Language create(Language lang) {
		return langRepo.save(lang);
	}
	public Language update(Language lang) {
		return langRepo.save(lang);
	}
	public void delete(Long id) {
		langRepo.deleteById(id);
	}
}
