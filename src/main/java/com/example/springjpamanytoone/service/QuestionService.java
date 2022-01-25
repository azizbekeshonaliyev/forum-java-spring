package com.example.springjpamanytoone.service;

import com.example.springjpamanytoone.model.QuestionForm;
import com.example.springjpamanytoone.model.QuestionItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuestionService {

    Page<QuestionItem> index(Pageable pageable);

    QuestionItem store(QuestionForm form);

    void delete(Long id);
}
