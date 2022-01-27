package com.example.springjpamanytoone.repository;

import com.example.springjpamanytoone.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User>{
    Optional<User> findByEmail(String email);
}
