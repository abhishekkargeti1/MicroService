package com.quiz.services;

import com.quiz.entities.Quiz;
import com.quiz.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizSeviceImpl implements  QuizService{
     @Autowired
     private QuizRepository repository;
     @Autowired
     private QuestionClient questionClient;

    @Override
    public Quiz add(Quiz quiz) {
        return repository.save(quiz);
    }

    @Override
    public List<Quiz> get() {
      List<Quiz> quizList =  repository.findAll();
        for(Quiz q : quizList){
           q.setQuestions(questionClient.getQuestion(q.getId()));
        }
        return quizList;
    }

    @Override
    public Quiz get(Long id) {

       Quiz quizById = repository.findById(id).orElseThrow(() -> new RuntimeException("Quiz Not Found"));

       quizById.setQuestions(questionClient.getQuestion(quizById.getId()));


       return quizById;
    }
}
