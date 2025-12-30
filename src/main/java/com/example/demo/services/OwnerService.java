package com.example.services;

import org.springframework.stereotype.Service;
import java.sql.Date;

import java.util.List;

import com.example.entities.Owner;
import com.example.repositories.OwnerRepository;

import com.example.mappers.OwnerMapper;

import com.example.dto.CreateOwnerDto;
import com.example.dto.GetOwnerDto;
import com.example.dto.FullGetOwnerDto;


@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;
    private final OwnerMapper ownerMapper;

    public OwnerService(OwnerRepository ownerRepository, OwnerMapper ownerMapper) {
        this.ownerRepository = ownerRepository;
        this.ownerMapper = ownerMapper;
    }

    public Owner createOwner(CreateOwnerDto dto) {
        var owner = ownerMapper.mapCreateDto(dto);
        return ownerRepository.save(owner);
    }

    public List<GetOwnerDto> getAllOwners() {
        return ownerRepository.findAll().stream().map((owner) -> ownerMapper.mapGetDto(owner)).toList(); 
    }


    public FullGetOwnerDto getOwnerById(Long id){
        return ownerMapper.mapFullGetDto(ownerRepository.findById(id).get()); 
    }   
}