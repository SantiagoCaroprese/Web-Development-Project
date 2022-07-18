package com.javeriana.web.project.Questions.Question.Application.UnAnsweredQuestions;

import com.javeriana.web.project.Questions.Question.Domain.Question;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class FindUnAnsweredQuestionsResponse {

    private List<Question> questionList;

    public FindUnAnsweredQuestionsResponse(List<Question> questionList) {
        this.questionList = questionList;
    }

    public List<HashMap> response() {
        List<HashMap> response = questionList.stream().map(a -> a.data()).collect(Collectors.toList());
        return  response;
    }
}
