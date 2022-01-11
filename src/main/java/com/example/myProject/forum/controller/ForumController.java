package com.example.myProject.forum.controller;

import com.example.myProject.forum.model.DTO.BoardDTO;
import com.example.myProject.forum.model.DTO.PostDTO;
import com.example.myProject.forum.model.DTO.ThreadDTO;
import com.example.myProject.forum.service.BoardService;
import com.example.myProject.forum.service.PostService;
import com.example.myProject.forum.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/forum")
@RestController
public class ForumController {
    @Autowired
    PostService postService;
    @Autowired
    BoardService boardService;
    @Autowired
    ThreadService threadService;

    @GetMapping(value = "/thread")
    public ResponseEntity<List<PostDTO>> getAllPosts() {
        return new ResponseEntity<>(postService.getPosts(), HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity<List<BoardDTO>> getAllBoards() {
        return new ResponseEntity<>(boardService.getBoards(), HttpStatus.OK);
    }
    @GetMapping(value = "/board")
    public ResponseEntity<List<ThreadDTO>> getAllThreads() {
        return new ResponseEntity<>(threadService.getThreads(), HttpStatus.OK);
    }
    @PostMapping(value = "/post/{id}/{id2}")
    public ResponseEntity<String> createPost(@RequestBody PostDTO postDTO,@PathVariable("id") Long idAuthor, @PathVariable("id2") Long idThread) {
        postService.createPost(postDTO, idAuthor, idThread);
        return new ResponseEntity<>("Post is added successfully", HttpStatus.CREATED);
    }
    @PostMapping(value = "/board")
    public ResponseEntity<String> createBoard(@RequestBody BoardDTO boardDTO) {
        boardService.createBoard(boardDTO);
        return new ResponseEntity<>("Board is added successfully", HttpStatus.CREATED);
    }
    @PostMapping(value = "/thread/{id}/{id2}")
    public ResponseEntity<String> createThread(@RequestBody ThreadDTO threadDTO,@PathVariable("id") Long idAuthor, @PathVariable("id2") Long idBoard) {
        threadService.createThread(threadDTO, idAuthor, idBoard);
        return new ResponseEntity<>("Thread is added successfully", HttpStatus.CREATED);
    }
    @GetMapping(value = "/posts/{id}")
    public ResponseEntity<List<PostDTO>> getPostsByAuthorId(@PathVariable("id") Long idAuthor) {
        return new ResponseEntity<>(postService.getPostsByAuthorId(idAuthor), HttpStatus.OK);
    }
    @DeleteMapping(value = "/post/{id}")
    public ResponseEntity<String> deletePost(@PathVariable("id") Long id) {
        postService.deletePost(id);
        return new ResponseEntity<>("Post is deleted successfully", HttpStatus.OK);
    }
    @DeleteMapping(value = "/thread/{id}")
    public ResponseEntity<String> deleteThread(@PathVariable("id") Long id) {
        threadService.deleteThread(id);
        return new ResponseEntity<>("Thread is deleted successfully", HttpStatus.OK);
    }
    @DeleteMapping(value = "/board/{id}")
    public ResponseEntity<String> deleteBoard(@PathVariable("id") Long id) {
        boardService.deleteBoard(id);
        return new ResponseEntity<>("Board is deleted successfully", HttpStatus.OK);
    }
}
