package com.schoolPro.examQuestions.service.impl;

import com.schoolPro.examQuestions.model.Question;
import com.schoolPro.examQuestions.service.QuestionService;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JavaQuestionService implements QuestionService {

    private final List<Question> questions = new ArrayList<>();

    @Override
    public void addQuestion(Question question) {
        questions.add(question);
    }

    @Override
    public void removeQuestion(Question question) {
        questions.remove(question);
    }

    @Override
    public List<Question> findAll() {
        return questions;
    }

    public Question getRandomQuestion() {
        Random random = new Random();
        return questions.get(random.nextInt(questions.size()));
    }
}
