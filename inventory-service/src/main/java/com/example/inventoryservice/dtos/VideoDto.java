package com.example.inventoryservice.dtos;

import java.util.Date;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class VideoDto {
    private String name;
    private String url;
    private String description;
    private Date datePublication;
    private CreatorDto creator;
}
