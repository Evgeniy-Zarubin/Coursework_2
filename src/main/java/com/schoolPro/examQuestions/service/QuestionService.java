package com.schoolPro.examQuestions.service;

import com.schoolPro.examQuestions.model.Question;

import java.util.Set;

public interface QuestionService {
    void addQuestion(Question question);
    void removeQuestion(Question question);
    Set<Question> findAll();
}
