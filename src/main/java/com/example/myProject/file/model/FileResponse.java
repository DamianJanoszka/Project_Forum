package com.example.myProject.file.model;

import lombok.Data;

@Data
public class FileResponse {

    private String id;
    private String name;
    private Long size;
    private String url;
    private String contentType;

}
