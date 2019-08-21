package com.rotech.dojoOverflow.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rotech.dojoOverflow.models.Answer;
import com.rotech.dojoOverflow.models.Question;
import com.rotech.dojoOverflow.models.Tag;
import com.rotech.dojoOverflow.repositories.AnswerRepository;
import com.rotech.dojoOverflow.repositories.QuestionRepository;
import com.rotech.dojoOverflow.repositories.TagRepository;

@Service
public class QuestionService {
	private final QuestionRepository repo;
	private final AnswerRepository aRepo;
	private final TagRepository tagRepo;
	
	public QuestionService(QuestionRepository repo, AnswerRepository aRepo, TagRepository tagRepo) {
		this.repo = repo;
		this.aRepo = aRepo;
		this.tagRepo = tagRepo;
	}
	public List<Question> findAll() {
		return repo.findAll();
	}
	public Question findById(Long id) {
		Optional<Question> maybe = repo.findById(id);
		if(maybe.isPresent()) {
			return maybe.get();
		}else {
			return null;
		}
	}
	public Question create(Question question) {
		return repo.save(question);
	}
	public Question update(Question question) {
		return repo.save(question);
	}
	public Tag findOrCreateTag(String stag) {
		System.out.println("new addTag");
		
		Tag tag = new Tag();
		tag.setSubject(stag);
		
		Optional<Tag> maybe = tagRepo.findBySubject(stag);
		tag = maybe.isPresent() ?	maybe.get() : tagRepo.save(tag); 
		
		return tag;
	}
	public Question addAnswer(Question question, Answer answer ) {
		answer.setQuestion(question);
		question.addAnswer(answer);
		return repo.save(question);
	}
	public Question addAnswer(Long id, Answer answer) {
		Question question = this.findById(id);
		answer.setQuestion(question);
		question.addAnswer(answer);
		return repo.save(question);
	}

}