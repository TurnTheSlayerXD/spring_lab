package com.edu.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

import java.util.List;

import com.edu.dto.CreateOwnerDto;
import com.edu.dto.GetOwnerDto;
import com.edu.dto.FullGetOwnerDto;

import com.edu.services.OwnerService;
import com.edu.entities.Owner;



@RestController
public class OwnerController {

    private OwnerService ownerService; 

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/list/owners")
    public List<GetOwnerDto> list() {
        return ownerService.getAllOwners();
    }

    @PostMapping("/record/owners")
    public Long create(@Valid @RequestBody CreateOwnerDto ownerDto){
        System.out.printf("%s", ownerDto.toString());
        Owner ownerEntity = ownerService.createOwner(ownerDto);
        return ownerEntity.getId();
    }


    @GetMapping("/record/owners/{id}")
    public FullGetOwnerDto get(@PathVariable("id") Long id){
        return ownerService.getOwnerById(id);
    }

}