package com.example.inventoryservice.mappers;

import com.example.inventoryservice.dao.entities.Creator;
import com.example.inventoryservice.dtos.CreatorDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CreatorMapper {

    private ModelMapper modelMapper = new ModelMapper();

    public Creator fromCreatorDto(CreatorDto creatorDto) {
        return this.modelMapper.map(creatorDto, Creator.class);
    }

    public CreatorDto fromCreator(Creator creator) {
        return this.modelMapper.map(creator, CreatorDto.class);
    }
}
