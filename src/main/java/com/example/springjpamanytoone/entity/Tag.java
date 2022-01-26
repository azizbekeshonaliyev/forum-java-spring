package com.example.springjpamanytoone.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
public class Tag extends BaseEntity{
    private String name;

    @ManyToMany(mappedBy = "tags")
    private Set<Question> questions = new HashSet<>();
}