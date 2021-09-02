package com.example.myProject.forum.service;

import com.example.myProject.forum.model.DTO.PostDTO;

import java.util.List;

public interface PostService {
    List<PostDTO> getPosts();
    PostDTO getById(Long id);
}
