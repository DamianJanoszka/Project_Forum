package com.example.myProject.file.service;

import com.example.myProject.file.model.FileEntity;
import com.example.myProject.file.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class FileService {
    private final FileRepository fileRepo;

    @Autowired
    public FileService(FileRepository fileRepo){
        this.fileRepo = fileRepo;
    }

    public void save(MultipartFile file) throws IOException {
        FileEntity fileEntity = new FileEntity();
        fileEntity.setName(StringUtils.cleanPath(file.getOriginalFilename()));
        fileEntity.setContentType(file.getContentType());
        fileEntity.setData(file.getBytes());
        fileEntity.setSize(file.getSize());

        fileRepo.save(fileEntity);
    }

    public Optional<FileEntity> getFile(String id){
        return fileRepo.findById(id);
    }

    public List<FileEntity> getAllFiles() {
        return fileRepo.findAll();
    }
}
