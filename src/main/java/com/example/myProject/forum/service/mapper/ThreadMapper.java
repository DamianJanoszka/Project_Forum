package com.example.myProject.forum.service.mapper;

import com.example.myProject.forum.model.DTO.ThreadDTO;
import com.example.myProject.forum.model.entity.Thread;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ThreadMapper {
    ThreadMapper INSTANCE = Mappers.getMapper(ThreadMapper.class);
    @Mapping(source="thread.author.id", target="idAuthor")
    @Mapping(source="thread.board.id", target="idBoard")
    @Mapping(source="thread.postList", target="postList")
    ThreadDTO threadToThreadDTO(Thread thread);
    void updateThreadFromDto(ThreadDTO threadDTO, @MappingTarget Thread thread);
    List<ThreadDTO> threadListToThreadDTOList(List<Thread> threadList);
}
