package com.example.myProject.forum.service;

import com.example.myProject.forum.model.DTO.ThreadDTO;

import java.util.List;

public interface ThreadService {
    List<ThreadDTO> getThreads();
    ThreadDTO getById(Long id);
}
