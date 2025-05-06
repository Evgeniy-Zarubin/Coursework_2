package com.schoolPro.examQuestions.service;

import com.schoolPro.examQuestions.model.Question;
import java.util.List;

public interface ExaminerService {
    List<Question> getQuestions(int amount);
}