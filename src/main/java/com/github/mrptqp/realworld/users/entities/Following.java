package com.github.mrptqp.realworld.users.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Following {
    @Id
    private Long followerId;
}
