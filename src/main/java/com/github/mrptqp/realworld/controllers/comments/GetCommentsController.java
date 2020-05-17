package com.github.mrptqp.realworld.controllers.comments;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetCommentsController {
    @GetMapping("/articles/{slug}/comments")
    public String getComment(@PathVariable("slug") String slug) {
        return null; //return multiple comments
    }
}