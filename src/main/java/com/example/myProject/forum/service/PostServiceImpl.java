package com.example.myProject.forum.service;

import com.example.myProject.forum.model.DTO.PostDTO;
import com.example.myProject.forum.model.entity.Post;
import com.example.myProject.forum.repository.PostRepository;
import com.example.myProject.forum.repository.ThreadRepository;
import com.example.myProject.forum.service.mapper.PostMapper;
import com.example.myProject.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    PostRepository postRepo;
    @Autowired
    UserRepository userRepo;
    @Autowired
    ThreadRepository threadRepo;
    @Override
    public List<PostDTO> getPosts() {
        return PostMapper.INSTANCE.postListToPostDTOList(postRepo.findAll());
    }

    @Override
    public PostDTO getById(Long id) {
        return PostMapper.INSTANCE.postToPostDTO(postRepo.getById(id));
    }

    @Override
    public void deletePost(Long id) {
        postRepo.deleteById(id);
    }

    @Override
    public void createPost(PostDTO postDTO, Long idAuthor, Long idThread) {
        Post post = new Post();
        post.setAuthor(userRepo.getById(idAuthor));
        post.setThread(threadRepo.getById(idThread));
        post.setContent(postDTO.getContent());
        post.setCreated(postDTO.getCreated());
        postRepo.save(post);
    }
}
