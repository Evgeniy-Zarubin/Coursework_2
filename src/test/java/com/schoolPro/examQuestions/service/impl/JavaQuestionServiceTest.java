package com.schoolPro.examQuestions.service.impl;

import com.schoolPro.examQuestions.model.Question;
import com.schoolPro.examQuestions.service.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    @Mock
    @InjectMocks
    private QuestionService questionService;

    @BeforeEach
    void setup() {
        questionService = new JavaQuestionService();
    }

    @Test
    void testAddAndRemoveQuestion() {
        Question q1 = new Question("Что такое OOP?", "Объектно-ориентированное программирование");
        questionService.addQuestion(q1);
        assertEquals(1, questionService.findAll().size());
        questionService.removeQuestion(q1);
        assertTrue(questionService.findAll().isEmpty());
    }

    @Test
    void testGetRandomQuestion() {
        Question q1 = new Question("Что такое переменная?", "Переменная — это область памяти...");
        questionService.addQuestion(q1);
        Question retrieved = ((JavaQuestionService) questionService).getRandomQuestion();
        assertEquals(q1.getQuestion(), retrieved.getQuestion());
    }
}