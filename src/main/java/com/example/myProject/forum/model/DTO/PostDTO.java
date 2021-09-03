package com.example.myProject.forum.model.DTO;

import com.example.myProject.user.model.DTO.UserDTO;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
public class PostDTO {
    private Long id;
    private String content;
    private Long idAuthor;
    private Long idThread;
    private Instant created = Instant.now();
    private LocalDateTime lastUpdated;
}
