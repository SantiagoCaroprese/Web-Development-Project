package com.javeriana.web.project.Properties.Property.Domain.ValueObjects;

import java.util.HashMap;
import java.util.Objects;

public class SerializedQuestion {
    private String questionId;
    private String textQuestion;
    private String questionDate;
    private String answerText;

    public SerializedQuestion() {
    }

    public SerializedQuestion(String questionId, String textQuestion, String questionDate, String answerText) {
        this.questionId = questionId;
        this.textQuestion = textQuestion;
        this.questionDate = questionDate;
        this.answerText = answerText;
    }

    public HashMap<String,Object> data(){
        HashMap<String, Object> data= new HashMap<>(){{
            put("idQuestion",questionId);
            put("question",textQuestion);
            put("questionDate",questionDate);
            put("answer",answerText);
        }};
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SerializedQuestion that = (SerializedQuestion) o;
        return Objects.equals(questionId, that.questionId);
    }

    public boolean equalsSerializedQuestionId(SerializedQuestion serializedQuestion){
        return this.questionId.equals(serializedQuestion.getQuestionId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionId, textQuestion, questionDate,answerText);
    }

    public String getQuestionId() {
        return questionId;
    }

    public String getTextQuestion() {
        return textQuestion;
    }

    public String getQuestionDate() {
        return questionDate;
    }


    public String getAnswerText() {
        return answerText;
    }
}
