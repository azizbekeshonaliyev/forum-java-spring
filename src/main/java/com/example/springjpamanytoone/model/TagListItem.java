package com.example.springjpamanytoone.model;

import com.example.springjpamanytoone.entity.Tag;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@Setter
@Getter
public class TagListItem {

    private Long id;

    private String name;

    private Set<QuestionItem> questions;

    public static TagListItem fromTag(Tag tag){
        TagListItem item = new TagListItem();
        item.setId(tag.getId());
        item.setName(tag.getName());
        item.setQuestions(
                tag.getQuestions()
                        .stream()
                        .map(QuestionItem::fromQuestion)
                        .collect(Collectors.toSet())
        );
        return item;
    }
}
