package com.example.myProject.forum.model.entity;


import com.example.myProject.user.model.entity.User;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "threads")
@Data
public class Thread {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_thread")
    private Long id;
    @NotNull
    private String title;
    private String content;
    @ManyToOne
    @JoinColumn(name = "id")
    private User author;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_board")
    private Board board;
    @OneToMany(mappedBy = "thread", cascade=CascadeType.ALL)
    private List<Post> postList;
    private Instant created;
    private Instant lastUpdated;
}
