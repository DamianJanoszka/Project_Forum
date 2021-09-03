package com.example.myProject.forum.service;

import com.example.myProject.forum.model.DTO.ThreadDTO;
import com.example.myProject.forum.model.entity.Thread;
import com.example.myProject.forum.repository.BoardRepository;
import com.example.myProject.forum.repository.ThreadRepository;
import com.example.myProject.forum.service.mapper.ThreadMapper;
import com.example.myProject.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThreadServiceImpl implements ThreadService {
    @Autowired
    UserRepository userRepo;
    @Autowired
    BoardRepository boardRepo;
    @Autowired
    ThreadRepository threadRepo;
    @Autowired
    BoardService boardService;
    @Override
    public List<ThreadDTO> getThreads() {
        List<Thread> all = threadRepo.findAll();
        return ThreadMapper.INSTANCE.threadListToThreadDTOList(all);
    }

    @Override
    public ThreadDTO getById(Long id) {
        return ThreadMapper.INSTANCE.threadToThreadDTO(threadRepo.getById(id));
    }

    @Override
    public void deleteThread(Long id) {
        threadRepo.deleteById(id);
    }

    @Override
    public void createThread(ThreadDTO threadDTO, Long idAuthor, Long idBoard) {
        Thread thread = new Thread();
        thread.setBoard(boardRepo.getById(idBoard));
        thread.setAuthor(userRepo.getById(idAuthor));
        thread.setTitle(threadDTO.getTitle());
        thread.setContent(threadDTO.getContent());
        thread.setCreated(threadDTO.getCreated());
        boardService.addThreadsToBoard(thread,idBoard);
        threadRepo.save(thread);
    }

}
