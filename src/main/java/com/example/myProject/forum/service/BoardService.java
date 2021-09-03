package com.example.myProject.forum.service;

import com.example.myProject.forum.model.DTO.BoardDTO;
import com.example.myProject.forum.model.entity.Thread;

import java.util.List;

public interface BoardService {
    List<BoardDTO> getBoards();
    BoardDTO getById(Long id);
    void deleteBoard(Long id);
    void createBoard(BoardDTO boardDTO);
    void addThreadsToBoard(Thread thread, Long idBoard);
}
