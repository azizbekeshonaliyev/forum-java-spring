package com.example.springjpamanytoone.model;

import com.example.springjpamanytoone.entity.Tag;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TagItem {

    private Long id;

    private String name;

    public static TagItem fromTag(Tag tag){
        TagItem item = new TagItem();
        item.setId(tag.getId());
        item.setName(tag.getName());
        return item;
    }
}
