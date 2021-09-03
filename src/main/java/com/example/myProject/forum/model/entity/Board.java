package com.example.myProject.forum.model.entity;


import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "boards")
@Data
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_board")
    private Long id;
    @NotNull
    private String title;
    @OneToMany(mappedBy="board")
    private List<Thread> threadList;
}
