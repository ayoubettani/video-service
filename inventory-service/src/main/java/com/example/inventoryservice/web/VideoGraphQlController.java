package com.example.inventoryservice.web;

import com.example.inventoryservice.dao.entities.Creator;
import com.example.inventoryservice.dao.entities.Video;
import com.example.inventoryservice.dtos.CreatorDto;
import com.example.inventoryservice.service.CreatorService;
import com.example.inventoryservice.service.VideoService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Controller
@AllArgsConstructor
public class VideoGraphQlController {
    private CreatorService creatorService;
    private VideoService videoService;

    @QueryMapping
    public List<Video> videoList() {
        return videoService.videoList();
    }

    @QueryMapping
    public Creator creatorById(@Argument Long id) {
        return creatorService.creatorById(id);
    }

    @MutationMapping
    public Video saveVideo(@Argument Video video) {
        return videoService.saveVideo(video);
    }

    @MutationMapping
    public Creator saveCreator(@Argument CreatorDto CreatorDto) {
        return creatorService.saveCreator(CreatorDto);
    }

    @QueryMapping
    public CreatorDto getCreator(@Argument Long id) {
        return creatorService.getCreator(id);
    }

    @SubscriptionMapping("notifyVideoChange")
    public Flux<Video> notifyVideoChange() {

        // A flux is the publisher of data
        return Flux.fromStream(
                Stream.generate(() -> {

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    Random random = new Random();

                    CreatorDto creatorDto = CreatorDto.builder().name("x" + random.nextInt())
                            .email("x@gmail.com").build();

                    Creator creator = creatorService.saveCreator(creatorDto);
                    Video video = videoService.findById(1L);
                    video.setCreator(creator);
                    videoService.updateVideo(video);

                    return video;
                }));
    }
}
