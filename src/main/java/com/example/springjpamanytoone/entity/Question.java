package com.example.springjpamanytoone.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
public class Question extends BaseEntity{

    private String title;

    private String content;

    @OneToMany(mappedBy = "question")
    private Set<Answer> answers =  new HashSet<>();

    @ManyToMany
    @JoinTable(
                name = "question_tag",
                joinColumns = @JoinColumn(name = "question_id"),
                inverseJoinColumns = @JoinColumn(name = "tag_id")
            )
    private Set<Tag> tags = new HashSet<>();
}
