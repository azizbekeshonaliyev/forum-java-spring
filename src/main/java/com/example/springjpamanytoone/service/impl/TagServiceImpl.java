package com.example.springjpamanytoone.service.impl;

import com.example.springjpamanytoone.entity.Tag;
import com.example.springjpamanytoone.model.TagItem;
import com.example.springjpamanytoone.model.TagListItem;
import com.example.springjpamanytoone.repository.TagRepository;
import com.example.springjpamanytoone.service.TagService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public List<TagListItem> list(String keyword) {
        return tagRepository.findTop10ByNameContainingIgnoreCase(keyword)
                .stream()
                .map(TagListItem::fromTag)
                .collect(Collectors.toList());
    }

    @Override
    public TagItem store(TagItem item) {
        Tag tag = new Tag();
        tag.setName(item.getName());
        tagRepository.save(tag);
        return TagItem.fromTag(tag);
    }
}
