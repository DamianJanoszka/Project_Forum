package com.example.myProject.forum.service;

import com.example.myProject.forum.model.DTO.BoardDTO;
import com.example.myProject.forum.model.entity.Board;
import com.example.myProject.forum.repository.BoardRepository;
import com.example.myProject.forum.service.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{
    @Autowired
    private BoardRepository boardRepo;
    @Override
    public List<BoardDTO> getBoards() {
        return BoardMapper.INSTANCE.boardListToBoardDTOList(boardRepo.findAll());
    }

    @Override
    public BoardDTO getById(Long id) {
        return BoardMapper.INSTANCE.boardToBoardDTO(boardRepo.getById(id));
    }

    @Override
    public void deleteBoard(Long id) {
        boardRepo.deleteById(id);
    }

    @Override
    public void createBoard(BoardDTO boardDTO) {
        Board board = new Board();
        board.setId(boardDTO.getId());
        board.setTitle(boardDTO.getTitle());
        boardRepo.save(board);
    }

}
