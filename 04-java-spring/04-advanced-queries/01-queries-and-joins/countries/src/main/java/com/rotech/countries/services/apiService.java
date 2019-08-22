package com.rotech.countries.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rotech.countries.repositories.CityRepo;
import com.rotech.countries.repositories.CountryRepo;
import com.rotech.countries.repositories.LanguageRepo;

@Service
public class apiService {
	private final CountryRepo cRepo;
	private final CityRepo ciRepo;
	private final LanguageRepo lRepo;
	
	public apiService(CountryRepo cRepo, CityRepo ciRepo, LanguageRepo lRepo) {
		this.cRepo = cRepo;
		this.ciRepo = ciRepo;
		this.lRepo = lRepo;
	}
	
	public List<Object[]> howManyCities(){
		return cRepo.howManyCities();
	}
	public List<Object[]> whoSpeaksSlovene(){
		return cRepo.whoSpeaksSlovene();
	}
	public List<Object[]> whoSpeaksSlovene2(){
		return cRepo.whoSpeaksSlovene2();
	}
	public List<Object[]> halfMiliMexiCity(){
		return cRepo.halfMiliMexiCitz();
	}
	public List<Object[]> majorLangs(){
		return cRepo.topLangsInCountries();
	}
	public List<Object[]> bigLilCountries(){
		return cRepo.bigLittleCountries();
	}
	public List<Object[]> bigMons(){
		return cRepo.bigMonarch();
	}
	public List<Object[]> wassupBuenosAires(){
		return cRepo.wassupBuenosAires();
	}
	public List<Object[]> countryZ(){
		return cRepo.countryZ();
	}
}
