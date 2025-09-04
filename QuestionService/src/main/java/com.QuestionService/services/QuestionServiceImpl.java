package com.QuestionService.services;

import com.QuestionService.entities.Question;
import com.QuestionService.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements   QuestionService{

    @Autowired
    QuestionRepository repository;


    @Override
    public Question createQuestion(Question question) {
        return repository.save(question);
    }

    @Override
    public List<Question> getAllQuestions() {
        return repository.findAll();
    }

    @Override
    public Question getQuestionById(Long id) {
        return repository.findById(id).orElseThrow(()-> new RuntimeException("No Data Found"));
    }

    @Override
    public List<Question> getQuestionByQuizId(Long quizId) {
        return repository.findByQuizId(quizId);
    }
}
