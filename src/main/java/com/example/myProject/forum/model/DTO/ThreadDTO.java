package com.example.myProject.forum.model.DTO;

import com.example.myProject.user.model.DTO.UserDTO;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ThreadDTO {
    private Long id;
    private String title;
    private UserDTO author;
    private String content;
    private BoardDTO board;
    private List<PostDTO> postList;
    private Instant created = Instant.now();
    private LocalDateTime lastUpdated;
}
