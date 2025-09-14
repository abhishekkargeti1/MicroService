package com.quiz.services;

import com.quiz.entities.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//@FeignClient(url="http://localHost:8080" ,value = "Question-Client")
@FeignClient(name = "QuestionService" )
public interface QuestionClient {

    @GetMapping("/question/byQuizId/{quizId}")
    public List<Question> getQuestion(@PathVariable Long quizId);
}
