package com.schoolPro.examQuestions.controller;

import com.schoolPro.examQuestions.model.Question;
import com.schoolPro.examQuestions.service.ExaminerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private final ExaminerService examinerService;

    @Autowired
    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public List<Question> getQuestions(@PathVariable int amount) {
        try {
            return examinerService.getQuestions(amount);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}