package com.example.inventoryservice.service;

import com.example.inventoryservice.dao.entities.Video;

import java.util.List;

public interface VideoService {
    Video findById(long l);

    Video updateVideo(Video video);

    List<Video> videoList();

    Video saveVideo(Video video);
}
