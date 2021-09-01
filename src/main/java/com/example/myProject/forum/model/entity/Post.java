package com.example.myProject.forum.model.entity;


import com.example.myProject.user.model.entity.User;
import lombok.Data;

import javax.persistence.*;
import java.text.DateFormat;

@Entity
@Table(name = "posts")
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_post")
    private Long id;
    private String content;
    @ManyToOne
    @JoinColumn(name = "id")
    private User author;
    @ManyToOne
    @JoinColumn(name = "id_thread")
    private Thread thread;
    private final DateFormat created;
    private DateFormat lastUpdated;
}
