

package com.example.mappers;

import org.springframework.stereotype.Service;
import java.sql.Date;

import com.example.entities.Owner;
import com.example.dto.CreateOwnerDto;
import com.example.dto.GetOwnerDto;
import com.example.dto.FullGetOwnerDto;
import com.example.dto.GetCatDto;


@Service
public class OwnerMapper {

    public Owner mapCreateDto(CreateOwnerDto dto){
        Owner owner = new Owner();
        owner.setName(dto.name);
        owner.setBirthdate(Date.valueOf(dto.birthdate));
        return owner;
    }

    public GetOwnerDto mapGetDto(Owner owner){
        GetOwnerDto dto = new GetOwnerDto();
        dto.name = owner.getName();
        dto.id = owner.getId();
        dto.birthdate = owner.getBirthdate().toString();
        return dto;
    }

    public FullGetOwnerDto mapFullGetDto(Owner owner){
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