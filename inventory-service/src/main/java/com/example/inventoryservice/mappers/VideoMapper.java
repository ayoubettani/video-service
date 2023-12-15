package com.example.inventoryservice.mappers;

import com.example.inventoryservice.dao.entities.Creator;
import com.example.inventoryservice.dao.entities.Video;
import com.example.inventoryservice.dtos.CreatorDto;
import com.example.inventoryservice.dtos.VideoDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VideoMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public Video fromVideoDto(VideoDto videoDto) {
        return this.modelMapper.map(videoDto, Video.class);
    }

    public VideoDto fromVideo(Video video) {
        return this.modelMapper.map(video, VideoDto.class);
    }
}
