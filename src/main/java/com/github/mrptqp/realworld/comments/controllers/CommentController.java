package com.github.mrptqp.realworld.comments.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {

    @PostMapping("/articles/{slug}/comments")
    public String addComment(@PathVariable("slug") String slug,
                             @RequestBody CommentContent commentContent
    ) {
        return null; //returns the created Comment
    }

    @DeleteMapping("/articles/{slug}/comments/{id}")
    public String deleteComment(@PathVariable("slug") String slug,
                                @PathVariable("id") String id
    ) {
        return "The comment has been deleted.";
    }

    @GetMapping("/articles/{slug}/comments")
    public String getComment(@PathVariable("slug") String slug) {
        return null; //return multiple comments
    }
}
