package com.schoolPro.examQuestions.service.impl;

import com.schoolPro.examQuestions.model.Question;
import com.schoolPro.examQuestions.service.QuestionService;
import java.util.*;

public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();

    @Override
    public void addQuestion(Question question) {
        questions.add(question);
    }

    @Override
    public void removeQuestion(Question question) {
        questions.remove(question);
    }

    @Override
    public Set<Question> findAll() {
        return questions;
    }

    public Question getRandomQuestion() {
        Random random = new Random();
        int index = random.nextInt(questions.size());
        Object[] array = questions.toArray();
        return (Question) array[index];
    }
}
