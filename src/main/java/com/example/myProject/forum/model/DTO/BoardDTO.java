package com.example.myProject.forum.model.DTO;

import com.example.myProject.forum.model.entity.Thread;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class BoardDTO {
    private Long id;
    private String title;
    private List<ThreadDTO> threadList;
}
