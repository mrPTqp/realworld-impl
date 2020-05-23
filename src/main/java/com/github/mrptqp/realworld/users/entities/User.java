package com.github.mrptqp.realworld.users.entities;

import com.github.mrptqp.realworld.articles.entities.Article;
import com.github.mrptqp.realworld.comments.entities.Comment;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Email
    private String email;

    private String username;

    private String password;

    private String bio;

    private String image;

    private String token;

    private LocalDateTime expireDate;

    @ManyToMany
    @JoinTable(
            name = "user_follower",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "follower_id")
    )
    private Set<Follower> followers = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Article> articles;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Comment> comments;
}
