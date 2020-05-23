package com.github.mrptqp.realworld.tags.entities;

import com.github.mrptqp.realworld.articles.entities.Article;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "tags")
    private Set<Article> articles;
}
