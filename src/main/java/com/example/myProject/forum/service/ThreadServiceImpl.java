package com.example.myProject.forum.service;

import com.example.myProject.forum.model.DTO.ThreadDTO;
import com.example.myProject.forum.repository.ThreadRepository;
import com.example.myProject.forum.service.mapper.ThreadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThreadServiceImpl implements ThreadService {
    @Autowired
    ThreadRepository threadRepo;
    @Override
    public List<ThreadDTO> getThreads() {
        return ThreadMapper.INSTANCE.threadListToThreadDTOList(threadRepo.findAll());
    }

    @Override
    public ThreadDTO getById(Long id) {
        return ThreadMapper.INSTANCE.threadToThreadDTO(threadRepo.getById(id));
    }
}
