package com.example.myProject.forum.model.entity;


import com.example.myProject.user.model.entity.User;
import lombok.Data;

import javax.persistence.*;
import java.text.DateFormat;
import java.util.List;

@Entity
@Table(name = "threads")
@Data
public class Thread {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_thread")
    private Long id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "id")
    private User author;
    @ManyToOne
    @JoinColumn(name = "id_board")
    private Board board;
    @OneToMany(mappedBy = "thread")
    private List<Post> postList;
    private final DateFormat created;
    private DateFormat lastUpdated;
}
