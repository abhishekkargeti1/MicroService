package com.QuestionService.controllers;

import com.QuestionService.entities.Question;
import com.QuestionService.services.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionServiceImpl service;

    @PostMapping("/add")
    public ResponseEntity<?> addQuestion(@RequestBody Question question){
            Question details = service.createQuestion(question);
            if(details != null) {
               return ResponseEntity.status(HttpStatus.OK).body(details);
            }else{
               return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllQuestion(){
       List<Question> questionList= service.getAllQuestions();
       if(!questionList.isEmpty()) {
           return ResponseEntity.status(HttpStatus.OK).body(questionList);
       }else{
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Data Found");
       }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getQuestionById(@PathVariable Long id){
            Question question =service.getQuestionById(id);
            if(question != null){
                return ResponseEntity.status(HttpStatus.OK).body(question);
            }else{
                return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Data Found");
            }
    }

    @GetMapping("/byQuizId/{quizId}")
    public ResponseEntity<?> getQuestionByQuizId(@PathVariable Long quizId){

        List<Question> questionList = service.getQuestionByQuizId(quizId);
        System.out.println("questionList "+questionList);
        if(!questionList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(questionList);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Data Found");
        }
    }



}
