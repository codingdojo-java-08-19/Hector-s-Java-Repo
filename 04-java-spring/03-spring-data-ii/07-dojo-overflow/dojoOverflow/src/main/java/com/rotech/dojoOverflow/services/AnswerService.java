
package com.rotech.dojoOverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rotech.dojoOverflow.models.Answer;
import com.rotech.dojoOverflow.models.Question;
import com.rotech.dojoOverflow.repositories.AnswerRepository;
import com.rotech.dojoOverflow.repositories.QuestionRepository;

@Service
public class AnswerService {
	private final AnswerRepository repo;
	private final QuestionRepository qRepo;
	public AnswerService(QuestionRepository qRepo, AnswerRepository repo) {
		this.qRepo = qRepo;
		this.repo = repo;
	}
	public List<Answer> findAll(){
		return repo.findAll();
	}
	public Answer findById(Long id) {
		Optional<Answer> maybe = repo.findById(id);
		if(maybe.isPresent()) {
			return maybe.get();
		}else {
			return null;
		}
	}
	public Answer findOrCreate(String sanswer) {
		Answer answer = new Answer();
		answer.setAnswer(sanswer);
		Optional<Answer> maybe = repo.findByAnswer(answer.getAnswer());
		answer = maybe.isPresent() ? maybe.get() : this.create(answer);
		return answer;
	}
	public Answer create(Answer answer) {
		return repo.save(answer);
	}
}
