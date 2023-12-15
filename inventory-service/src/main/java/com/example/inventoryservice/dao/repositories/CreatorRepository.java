package com.example.inventoryservice.dao.repositories;

import com.example.inventoryservice.dao.entities.Creator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreatorRepository extends JpaRepository<Creator,Long> {
}
