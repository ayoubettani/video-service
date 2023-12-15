package com.example.inventoryservice.dtos;


import com.example.inventoryservice.dao.entities.Video;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CreatorDto {
    private String name;
    private String email;
    //private List<VideoDto> videos;
}
