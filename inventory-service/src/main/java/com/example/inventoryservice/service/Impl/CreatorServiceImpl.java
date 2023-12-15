package com.example.inventoryservice.service.Impl;

import com.example.inventoryservice.dao.entities.Creator;
import com.example.inventoryservice.dao.repositories.CreatorRepository;
import com.example.inventoryservice.dtos.CreatorDto;
import com.example.inventoryservice.mappers.CreatorMapper;
import com.example.inventoryservice.service.CreatorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreatorServiceImpl implements CreatorService {

    private CreatorRepository creatorRepository;
    private CreatorMapper creatorMapper;


    @Override
    public Creator saveCreator(CreatorDto creatorDto) {
        Creator creator  = creatorMapper.fromCreatorDto(creatorDto);
        return creatorRepository.save(creator);
    }

    @Override
    public Creator creatorById(Long id) {
        return creatorRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Creator %s not found",id)));
    }

    @Override
    public CreatorDto getCreator(Long id) {
        Creator creator =  creatorRepository.findById(id).get();
        return this.creatorMapper.fromCreator(creator);
    }
}
