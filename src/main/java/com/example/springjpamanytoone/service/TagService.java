package com.example.springjpamanytoone.service;

import com.example.springjpamanytoone.model.TagItem;
import com.example.springjpamanytoone.model.TagListItem;

import java.util.List;

public interface TagService {

    List<TagListItem> list(String keyword);

    TagItem store(TagItem item);

}
