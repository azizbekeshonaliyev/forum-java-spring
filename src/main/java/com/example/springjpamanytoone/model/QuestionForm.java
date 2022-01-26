package com.example.springjpamanytoone.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
public class QuestionForm {

    private String title;

    private String content;

    private Set<AnswerForm> answers = new HashSet<>();

    private Set<TagItem> tags = new HashSet<>();

    @Setter
    @Getter
    public static class AnswerForm {
        private String content;
    }
}
