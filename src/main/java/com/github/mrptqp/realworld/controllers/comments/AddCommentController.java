package com.github.mrptqp.realworld.controllers.comments;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@RestController
@RequiredArgsConstructor
public class AddCommentController {
    @PostMapping("/articles/{slug}/comments")
    public String addComment(
            @PathVariable("slug") String slug,
            @RequestBody CommentContent commentContent) {
        return null; //returns the created Comment
    }
}

@Getter
@JsonRootName("comment")
@NoArgsConstructor
class CommentContent {
    @NotBlank(message = "can't be empty")
    private String body;
}