package com.schoolPro.examQuestions.service;

import com.schoolPro.examQuestions.model.Question;
import java.util.List;

public interface QuestionService {
    void addQuestion(Question question);
    void removeQuestion(Question question);
    List<Question> findAll();
}
