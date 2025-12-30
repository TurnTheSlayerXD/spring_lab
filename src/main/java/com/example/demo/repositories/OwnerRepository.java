package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
}