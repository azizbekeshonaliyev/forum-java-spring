package com.example.springjpamanytoone.repository;

import com.example.springjpamanytoone.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag,Long> {
    List<Tag> findTop10ByNameContainingIgnoreCase(String keyword);
}
