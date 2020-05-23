package com.github.mrptqp.realworld.articles.entities;

import com.github.mrptqp.realworld.comments.entities.Comment;
import com.github.mrptqp.realworld.tags.entities.Tag;
import com.github.mrptqp.realworld.users.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String slug;

    private String title;

    private String description;

    private String body;

    @ManyToMany
    @JoinTable(
            name = "article_tag",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private boolean favorited;

    private int favoritesCount;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "article")
    private Set<Comment> comments;
}
