package com.example.springjpamanytoone.controller;

import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("api/v1/test")
public class TestController {

    private final MessageSource messageSource;

    public TestController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping
    public String test(@RequestHeader String lang){
        return messageSource.getMessage("hello",null, new Locale(lang));
    }

}
