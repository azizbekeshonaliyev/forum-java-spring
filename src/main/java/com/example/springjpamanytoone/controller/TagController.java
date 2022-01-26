package com.example.springjpamanytoone.controller;

import com.example.springjpamanytoone.model.TagItem;
import com.example.springjpamanytoone.model.TagListItem;
import com.example.springjpamanytoone.service.TagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tag")
public class TagController
{
    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    public List<TagListItem> list(@RequestParam(required = false) String keyword){
        return tagService.list(keyword);
    }

    @PostMapping
    public TagItem store(@RequestBody TagItem item){
        return tagService.store(item);
    }
}
