package com.example.springjpamanytoone.model;

import com.example.springjpamanytoone.entity.Answer;
import com.example.springjpamanytoone.entity.Question;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@Setter
@Getter
public class QuestionItem {

    private Long id;

    private String title;

    private String content;

    private Set<AnswerItem> answers;

    private Set<TagItem> tags;

    public static QuestionItem fromQuestion(Question question) {
        QuestionItem questionItem = new QuestionItem();
        questionItem.setId(question.getId());
        questionItem.setTitle(question.getTitle());
        questionItem.setContent(question.getContent());
        questionItem.setAnswers(
                question.getAnswers()
                .stream()
                .map(AnswerItem::fromAnswer)
                .collect(Collectors.toSet())
        );
        questionItem.setTags(
                question.getTags()
                .stream()
                .map(TagItem::fromTag)
                .collect(Collectors.toSet())
        );
        return questionItem;
    }

    @Getter
    @Setter
    public static class AnswerItem{
        private String content;

        public static AnswerItem fromAnswer(Answer answer){
            AnswerItem answerItem = new AnswerItem();
            answerItem.setContent(answer.getContent());
            return answerItem;
        }
    }
}