package com.example.myProject.forum.service.mapper;

import com.example.myProject.forum.model.DTO.BoardDTO;
import com.example.myProject.forum.model.entity.Board;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BoardMapper {
    BoardMapper INSTANCE = Mappers.getMapper( BoardMapper.class );
    @Mapping(source="board.threadList", target="threadList")
    BoardDTO boardToBoardDTO(Board board);
    void updateBoardFromDto(BoardDTO boardDTO, @MappingTarget Board board);
    List<BoardDTO> boardListToBoardDTOList(List<Board> boardList);
}
