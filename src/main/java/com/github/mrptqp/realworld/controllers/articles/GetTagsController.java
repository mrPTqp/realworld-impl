package com.github.mrptqp.realworld.controllers.articles;

import com.github.mrptqp.realworld.models.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetTagsController {

    @GetMapping("/tags")
    public Profile getTags() {
        return null; //returns a List of Tags
    }
}
