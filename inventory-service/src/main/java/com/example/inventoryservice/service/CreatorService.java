package com.example.inventoryservice.service;

import com.example.inventoryservice.dao.entities.Creator;
import com.example.inventoryservice.dtos.CreatorDto;

public interface CreatorService {
    Creator saveCreator(CreatorDto creatorDto);

    Creator creatorById(Long id);

    CreatorDto getCreator(Long id);
}
