package com.example.myProject.user.model.entity;

import com.example.myProject.forum.model.entity.Post;
import com.example.myProject.forum.model.entity.Thread;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    @Column(unique=true)
    private String login;
    private String password;
    @ManyToOne
    @JoinColumn(name = "id_role")
    private UserRole userRole;
    @OneToMany(mappedBy = "author")
    private Set<Post> posts;
    @OneToMany(mappedBy = "author")
    private Set<Thread> threads;
}
