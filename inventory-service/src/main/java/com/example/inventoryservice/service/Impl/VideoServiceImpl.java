package com.example.inventoryservice.service.Impl;

import com.example.inventoryservice.dao.entities.Video;
import com.example.inventoryservice.dao.repositories.CreatorRepository;
import com.example.inventoryservice.dao.repositories.VideoRepository;
import com.example.inventoryservice.service.VideoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VideoServiceImpl implements VideoService {

    private VideoRepository videoRepository;

    private CreatorRepository creatorRepository;


    @Override
    public Video findById(long id) {
        return videoRepository.findById(id).get();
    }

    @Override
    public Video updateVideo(Video video) {
        return videoRepository.save(video);
    }

    @Override
    public List<Video> videoList() {
        return videoRepository.findAll();
    }

    @Override
    public Video saveVideo(Video video) {
        creatorRepository.save(video.getCreator());
        return videoRepository.save(video);
    }
}
