package com.javeriana.web.project.Questions.Question.Infrastructure.Controllers;


import com.javeriana.web.project.Questions.Question.Application.UnAnsweredQuestions.FindUnAnsweredQuestions;
import com.javeriana.web.project.Questions.Question.Application.UnAnsweredQuestions.FindUnAnsweredQuestionsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/questions")
public class ViewUnAnsweredQuestionsGetController {

    @Autowired
    FindUnAnsweredQuestions findUnAnsweredQuestions;

    @GetMapping(value = "/unanswered")
    public ResponseEntity<List<HashMap>> execute(){
        FindUnAnsweredQuestionsResponse response = new FindUnAnsweredQuestionsResponse(findUnAnsweredQuestions.execute());
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<HashMap> handleException(Exception exception){
        HashMap<String,String> response = new HashMap<>(){{
            put("error",exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
