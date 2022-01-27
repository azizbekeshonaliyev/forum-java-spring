package com.example.springjpamanytoone.repository.impl;


import com.example.springjpamanytoone.entity.BaseEntity;
import com.example.springjpamanytoone.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class BaseRepositoryImpl<T extends BaseEntity>
    extends SimpleJpaRepository<T, Long>
    implements BaseRepository<T> {

    private final Specification<T> notDeleted;

    public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        notDeleted = (root, query, cb) -> cb.equal(root.get("deleted"), false);
    }

    T trash(Long id){
        T item = getOne(id);
        item.setDeleted(true);
        save(item);
        return item;
    }

    List<T> findAllByNotDeleted(){ return findAll(notDeleted);}

    Page<T> findAllByNotDeleted(Pageable pageable){ return findAll(notDeleted,pageable); }
}
