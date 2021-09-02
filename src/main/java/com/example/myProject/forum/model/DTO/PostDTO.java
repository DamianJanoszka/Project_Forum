package com.example.myProject.forum.model.DTO;

import com.example.myProject.user.model.DTO.UserDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostDTO {
    private Long id;
    private String content;
    private UserDTO author;
    private ThreadDTO thread;
    private LocalDateTime created;
    private LocalDateTime lastUpdated;
}
