package com.schoolPro.examQuestions.controller;

import com.schoolPro.examQuestions.model.Question;
import com.schoolPro.examQuestions.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final QuestionService questionService;

    @Autowired
    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/add")
    public void addQuestion(@RequestParam String question, @RequestParam String answer) {
        questionService.addQuestion(new Question(question, answer));
    }

    @DeleteMapping("/remove")
    public void removeQuestion(@RequestParam String question, @RequestParam String answer) {
        questionService.removeQuestion(new Question(question, answer));
    }

    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.findAll();
    }
}
