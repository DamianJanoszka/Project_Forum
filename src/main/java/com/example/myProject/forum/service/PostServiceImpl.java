package com.example.myProject.forum.service;

import com.example.myProject.forum.model.DTO.PostDTO;
import com.example.myProject.forum.repository.PostRepository;
import com.example.myProject.forum.service.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    PostRepository postRepo;
    @Override
    public List<PostDTO> getPosts() {
        return PostMapper.INSTANCE.postListToPostDTOList(postRepo.findAll());
    }

    @Override
    public PostDTO getById(Long id) {
        return PostMapper.INSTANCE.postToPostDTO(postRepo.getById(id));
    }
}
