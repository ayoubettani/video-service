package com.example.inventoryservice.dao.repositories;

import com.example.inventoryservice.dao.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<Video,Long> {
}
