package com.example.springjpamanytoone.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Answer extends BaseEntity{

    private String content;

    @ManyToOne
    private Question question;
}
