package com.example.myProject.forum.service.mapper;

import com.example.myProject.forum.model.DTO.PostDTO;
import com.example.myProject.forum.model.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper( PostMapper.class );
    @Mapping(source="post.author.id", target="idAuthor")
    @Mapping(source = "post.thread.id", target = "idThread")
    PostDTO postToPostDTO(Post post);
    void updatePostFromDto(PostDTO postDTO, @MappingTarget Post post);
    List<PostDTO> postListToPostDTOList(List<Post> postList);
}
