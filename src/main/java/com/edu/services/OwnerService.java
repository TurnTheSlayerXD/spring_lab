package com.edu.services;

import org.springframework.stereotype.Service;
import java.util.List;

import com.edu.entities.Owner;
import com.edu.exceptions.InvalidBirthdateException;
import com.edu.repositories.OwnerRepository;

import com.edu.dto.CreateOwnerDto;
import com.edu.dto.GetOwnerDto;
import com.edu.dto.FullGetOwnerDto;
import com.edu.dto.GetCatDto;


@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public Owner createOwner(CreateOwnerDto dto) {
        var owner = mapCreateDto(dto);
        return ownerRepository.save(owner);
    }

    public List<GetOwnerDto> getAllOwners() {
        return ownerRepository.findAll().stream().map((owner) -> mapGetDto(owner)).toList(); 
    }

    public FullGetOwnerDto getOwnerById(Long id){
        return mapFullGetDto(ownerRepository.findById(id).get()); 
    }   

    public static Owner mapCreateDto(CreateOwnerDto dto){
        Owner owner = new Owner();
        owner.setName(dto.name);
        try {
            owner.setBirthdate(DateParser.dateToSqlDate(dto.birthdate));
        }
        catch (IllegalArgumentException e) {
            throw new InvalidBirthdateException();
        }
        return owner;
    }

    public static GetOwnerDto mapGetDto(Owner owner){
        GetOwnerDto dto = new GetOwnerDto();
        dto.name = owner.getName();
        dto.id = owner.getId();
        dto.birthdate = owner.getBirthdate().toString();
        return dto;
    }

    public static FullGetOwnerDto mapFullGetDto(Owner owner){
        var dto = new FullGetOwnerDto();
        dto.name = owner.getName();
        dto.id = owner.getId();
        dto.birthdate = owner.getBirthdate().toString();
        dto.cats = owner.getCats().stream().map(cat -> { 
            GetCatDto catDto = new GetCatDto();
            catDto.id = cat.getId();
            catDto.name = cat.getName();
            catDto.ownerId = owner.getId();
            return catDto;
        }).toList();
        return dto;
    }
}