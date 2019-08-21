package com.rotech.dojoOverflow.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.rotech.dojoOverflow.models.Question;

public interface QuestionRepository extends CrudRepository<Question, Long> {
	List<Question>findAll();
	Optional<Question> findByQuestion(String question);
//	Question save(Question question);
}
