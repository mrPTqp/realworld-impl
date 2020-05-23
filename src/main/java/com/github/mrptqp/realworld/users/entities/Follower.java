package com.github.mrptqp.realworld.users.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Follower {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long follower;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "followers")
    private Set<User> users;

}
