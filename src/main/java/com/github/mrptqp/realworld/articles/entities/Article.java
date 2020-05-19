package com.github.mrptqp.realworld.articles.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.mrptqp.realworld.tags.entities.Tag;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    private String slug;

    private String title;

    private String description;

    private String body;

    @OneToMany
    private List<Tag> tagList;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private boolean favorited;

    private int favoritesCount;


}
