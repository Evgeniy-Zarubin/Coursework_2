package com.schoolPro.examQuestions.service.impl;

import com.schoolPro.examQuestions.model.Question;
import com.schoolPro.examQuestions.service.ExaminerService;
import com.schoolPro.examQuestions.service.QuestionService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public List<Question> getQuestions(int amount) {
        List<Question> allQuestions = questionService.findAll();
        if (allQuestions.size() < amount) {
            throw new IllegalArgumentException("Количество запрашиваемых вопросов превышает доступные!");
        }

        List<Question> shuffledQuestions = new ArrayList<>(allQuestions);
        Collections.shuffle(shuffledQuestions);
        return shuffledQuestions.subList(0, amount);
    }
}