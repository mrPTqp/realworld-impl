package com.github.mrptqp.realworld.tags.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TagsController {

    @GetMapping("/tags")
    public String getTags() { //but must return "List of Tags"!!!!!!!!!!!!!!!!!!!!!!!!!!
        return "{\"tags\":[\"reactjs\",\"angularjs\"]}";
    }
}
