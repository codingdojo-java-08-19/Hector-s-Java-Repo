package com.rotech.countries.repositories;

import org.springframework.data.repository.CrudRepository;

import com.rotech.countries.models.Language;

public interface LanguageRepo extends CrudRepository<Language, Long> {

}
