package com.edu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.entities.Owner;


@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
}