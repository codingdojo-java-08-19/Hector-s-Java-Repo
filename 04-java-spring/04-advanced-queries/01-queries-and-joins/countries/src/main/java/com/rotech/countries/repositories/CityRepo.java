package com.rotech.countries.repositories;

import org.springframework.data.repository.CrudRepository;

import com.rotech.countries.models.City;

public interface CityRepo extends CrudRepository<City, Long> {

}
