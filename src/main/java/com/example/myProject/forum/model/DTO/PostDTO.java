package com.example.myProject.forum.model.DTO;

import lombok.Data;

import java.time.Instant;

@Data
public class PostDTO {
    private Long id;
    private String content;
    private Long idAuthor;
    private Long idThread;
    private Instant created = Instant.now();
    private Instant lastUpdated = Instant.now();
}
