package com.quiz.controller;

import com.quiz.entities.Quiz;
import com.quiz.services.QuizSeviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizSeviceImpl service;

    @PostMapping("/add")
    public ResponseEntity<?> addQuiz(@RequestBody Quiz quiz){
        Quiz details = service.add(quiz);
        if(details != null){
            return ResponseEntity.status(HttpStatus.OK).body(details);
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllQuiz(){
        List<Quiz> quizList = service.get();
        if(quizList != null) {
            return ResponseEntity.status(HttpStatus.OK).body(quizList);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NO Data Found");
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Quiz quizDetails = service.get(id);
        if(quizDetails != null) {
            return ResponseEntity.status(HttpStatus.OK).body(quizDetails);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NO Data Found");
        }
    }

}
