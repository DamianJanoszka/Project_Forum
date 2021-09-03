package com.example.myProject.forum.model.DTO;

import lombok.Data;

import java.util.List;

@Data
public class BoardDTO {
    private Long id;
    private String title;
    private List<ThreadDTO> threadList;
}
