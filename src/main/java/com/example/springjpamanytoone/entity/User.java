package com.example.springjpamanytoone.entity;

import com.example.springjpamanytoone.model.UserRole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "my_user")
public class User extends BaseEntity{

    private String firstName;

    private String LastName;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;
}
