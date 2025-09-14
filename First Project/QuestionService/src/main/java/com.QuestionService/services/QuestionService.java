package com.QuestionService.services;

import com.QuestionService.entities.Question;

import java.util.List;

public interface QuestionService {

    public Question createQuestion(Question question);

    public List<Question> getAllQuestions();

    public Question getQuestionById(Long id);

    public List<Question> getQuestionByQuizId(Long quizId);
}
