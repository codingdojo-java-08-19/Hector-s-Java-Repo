package com.rotech.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rotech.countries.models.Country;

public interface CountryRepo extends CrudRepository<Country,Long> {
	@Query("SELECT c.name, COUNT(ci.id) as cityCount FROM Country c JOIN c.cities ci GROUP BY c.id ORDER BY cityCount DESC")
	List<Object[]>howManyCities();
	
	
	//remember that model fields names must match with the database.
	// I was geting 0.0 for the percentage because I had it spelled "precentage" in my model
	@Query("SELECT c.name, l.percentage FROM Country c JOIN c.languages l WHERE l.language = 'Slovene' ORDER BY l.percentage DESC")
	List<Object[]> whoSpeaksSlovene();
	//but hey I got a native query out of misspelling!
	@Query(value="SELECT name, percentage FROM world.countries JOIN languages WHERE language = 'Slovene' AND countries.id = country_id ORDER BY percentage desc;", nativeQuery=true)
	List<Object[]> whoSpeaksSlovene2();
	
	@Query("SELECT ci.name,ci.population FROM Country c JOIN c.cities ci WHERE c.name='Mexico' AND ci.population > 500000 ORDER BY ci.population DESC ")
	List<Object[]> halfMiliMexiCitz();
	
	@Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.percentage > 89.0 ORDER BY l.percentage DESC")
	List<Object[]> topLangsInCountries();
	
	@Query("SELECT c.name, c.population, c.surface_area FROM Country c WHERE c.surface_area < 501 AND c.population > 100000 ORDER BY c.population DESC")
	List<Object[]> bigLittleCountries();
	
	@Query("SELECT c.name FROM Country c WHERE c.government_form = 'Constitutional Monarchy' AND c.surface_area >200 AND c.life_expectancy > 75 ORDER BY c.life_expectancy DESC")
	List<Object[]> bigMonarch();
	
	@Query("SELECT c.name, ci.name, ci.district, ci.population FROM Country c JOIN c.cities ci WHERE c.name='Argentina' AND ci.district = 'Buenos Aires' AND ci.population > 500000")
	List<Object[]> wassupBuenosAires();
	
	@Query("SELECT c.region, COUNT(c) as countries FROM Country c GROUP BY c.region ORDER BY countries DESC")
	List<Object[]> countryZ();
}
