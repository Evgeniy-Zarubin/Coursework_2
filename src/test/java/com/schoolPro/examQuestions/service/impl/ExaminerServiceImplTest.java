package com.schoolPro.examQuestions.service.impl;

import com.schoolPro.examQuestions.model.Question;
import com.schoolPro.examQuestions.service.ExaminerService;
import com.schoolPro.examQuestions.service.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

    class ExaminerServiceImplTest {

        @Mock
        private QuestionService questionService;

        @InjectMocks
        private ExaminerService examinerService = new ExaminerServiceImpl(questionService);

        @BeforeEach
        void setup() {
            MockitoAnnotations.openMocks(this);
        }

        @Test
        @DisplayName("Получение корректного количества вопросов")
        void testGetQuestionsValidAmount() {
            Set<Question> expectedQuestions = new HashSet<>();
            expectedQuestions.add(new Question("Вопрос 1", "Ответ 1"));
            expectedQuestions.add(new Question("Вопрос 2", "Ответ 2"));
            when(questionService.findAll()).thenReturn(expectedQuestions);

            List<Question> actualQuestions = examinerService.getQuestions(2);
            assertEquals(2, actualQuestions.size());
        }

        @Test
        @DisplayName("Получение некорректного количества вопросов")
        void testGetQuestionsInvalidAmount() {
            Set<Question> questions = new HashSet<>();
            questions.add(new Question("Вопрос 1", "Ответ 1"));
            when(questionService.findAll()).thenReturn(questions);

            assertThrows(IllegalArgumentException.class, () -> examinerService.getQuestions(3));
        }
    }