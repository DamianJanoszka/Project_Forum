package com.example.myProject.forum.model.DTO;

import com.example.myProject.user.model.DTO.UserDTO;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ThreadDTO {
    private Long id;
    private String title;
    private UserDTO author;
    private BoardDTO board;
    private List<PostDTO> postList;
    private LocalDateTime created;
    private LocalDateTime lastUpdated;
}
