package com.example.springjpamanytoone.service.impl;

import com.example.springjpamanytoone.entity.Answer;
import com.example.springjpamanytoone.entity.Question;
import com.example.springjpamanytoone.model.QuestionForm;
import com.example.springjpamanytoone.model.QuestionItem;
import com.example.springjpamanytoone.repository.AnswerRepository;
import com.example.springjpamanytoone.repository.QuestionRepository;
import com.example.springjpamanytoone.service.QuestionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    public QuestionServiceImpl(QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    @Override
    public Page<QuestionItem> index(Pageable pageable) {
        return questionRepository.findAll(pageable).map(QuestionItem::fromQuestion);
    }

    @Override
    @Transactional
    public QuestionItem store(QuestionForm form) {

        Question question = new Question();
        question.setTitle(form.getTitle());
        question.setContent(form.getContent());
        questionRepository.save(question);
        for (QuestionForm.AnswerForm answerForm: form.getAnswers()) {
            Answer answer = new Answer();
            answer.setContent(answerForm.getContent());
            answer.setQuestion(question);
            answerRepository.save(answer);
            question.getAnswers().add(answer);
        }
        questionRepository.saveAndFlush(question);
        return QuestionItem.fromQuestion(question);
    }

    @Override
    public void delete(Long id) {
        questionRepository.deleteById(id);
    }
}
