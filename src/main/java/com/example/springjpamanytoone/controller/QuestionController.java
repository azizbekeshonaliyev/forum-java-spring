package com.example.springjpamanytoone.controller;

import com.example.springjpamanytoone.model.QuestionForm;
import com.example.springjpamanytoone.model.QuestionItem;
import com.example.springjpamanytoone.service.QuestionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public Page<QuestionItem> index(Pageable pageable){
        return questionService.index(pageable);
    }

    @PostMapping
    public QuestionItem store(@RequestBody QuestionForm form){
        return questionService.store(form);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Long id){
        questionService.delete(id);
        return true;
    }
}