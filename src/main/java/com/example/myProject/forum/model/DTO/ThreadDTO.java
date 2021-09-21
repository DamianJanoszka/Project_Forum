package com.example.myProject.forum.model.DTO;

import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class ThreadDTO {
    private Long id;
    private String title;
    private Long idAuthor;
    private String content;
    private Long idBoard;
    private List<PostDTO> postList;
    private Instant created = Instant.now();
    private Instant lastUpdated = Instant.now();
}
