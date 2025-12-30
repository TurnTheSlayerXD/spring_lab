package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Cat;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {
}