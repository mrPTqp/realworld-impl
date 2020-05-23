package com.github.mrptqp.realworld.comments.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeleteCommentsController {
    @DeleteMapping("/articles/{slug}/comments/{id}")
    public String deleteComment(@PathVariable("slug") String slug,
                                @PathVariable("id") String id
    ) {
        return "The comment has been deleted.";
    }
}