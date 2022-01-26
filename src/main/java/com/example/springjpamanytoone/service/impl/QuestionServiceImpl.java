package com.example.springjpamanytoone.service.impl;

import com.example.springjpamanytoone.entity.Answer;
import com.example.springjpamanytoone.entity.Question;
import com.example.springjpamanytoone.entity.Tag;
import com.example.springjpamanytoone.model.QuestionForm;
import com.example.springjpamanytoone.model.QuestionItem;
import com.example.springjpamanytoone.model.TagItem;
import com.example.springjpamanytoone.repository.AnswerRepository;
import com.example.springjpamanytoone.repository.QuestionRepository;
import com.example.springjpamanytoone.repository.TagRepository;
import com.example.springjpamanytoone.service.QuestionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final EntityManager entityManager;
    private final TagRepository tagRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository, AnswerRepository answerRepository, EntityManager entityManager, TagRepository tagRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.entityManager = entityManager;
        this.tagRepository = tagRepository;
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

        Set<Tag> tags = form.getTags()
                .stream()
                .map(item -> {
                    if (item.getId() != null){
                        return entityManager.find(Tag.class,item.getId());
                    }else {
                        Tag tag = new Tag();
                        tag.setName(item.getName());
                        return tagRepository.save(tag);
                    }
                })
                .collect(Collectors.toSet());

        question.setTags(tags);

        return QuestionItem.fromQuestion(question);
    }

    @Override
    public void delete(Long id) {
        questionRepository.deleteById(id);
    }
}
