package com.github.mrptqp.realworld.controllers.articles;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.github.mrptqp.realworld.entities.Tag;
import com.github.mrptqp.realworld.models.Profile;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CreateArticleController {

    @PostMapping("/articles")
    public Profile createArticles(@RequestBody ArticleContent articleContent) {
        return null; //Authentication required, will return an Article
    }
}

@Getter
@JsonRootName("article")
@NoArgsConstructor
class ArticleContent {
    @NotBlank(message = "can't be empty")
    private String title;
    @NotBlank(message = "can't be empty")
    private String description;
    @NotBlank(message = "can't be empty")
    private String body;
    private List<Tag> tagList;
}


