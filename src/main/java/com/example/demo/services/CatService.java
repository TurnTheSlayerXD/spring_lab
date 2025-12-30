package com.example.services;

import org.springframework.stereotype.Service;

import java.util.List;

import com.example.entities.Cat;
import com.example.entities.CatToCat;

import com.example.repositories.CatRepository;
import com.example.repositories.CatToCatRepository;
import com.example.repositories.OwnerRepository;


import com.example.mappers.CatMapper;

import com.example.dto.CreateCatDto;
import com.example.dto.GetCatDto;
import com.example.dto.FullGetCatDto;
import com.example.dto.PatchCatDto;

import com.example.exceptions.FriendshipAlreadyExistsException;

@Service
public class CatService {
    private CatRepository catRepository;
    private CatMapper catMapper;
    private OwnerRepository ownerRepository;
    private CatToCatRepository catToCatRepository;

    public CatService (CatRepository catRepository, CatMapper catMapper, CatToCatRepository catToCatRepository, OwnerRepository ownerRepository){
        this.catRepository = catRepository;
        this.catMapper = catMapper;
        this.catToCatRepository = catToCatRepository;
        this.ownerRepository = ownerRepository;
    }

    public FullGetCatDto createCat(CreateCatDto catDto){
        var cat = catMapper.mapCreateCatDto(catDto);
        cat.setOwner(ownerRepository.findById(catDto.ownerId).get());
        return catMapper.mapFullGetCatDto(catRepository.save(cat));
    }

    public FullGetCatDto getCatById(Long id){
        var catDto = catMapper.mapFullGetCatDto(catRepository.findById(id).get());
        catDto.friends = catToCatRepository.findFriendsOfCat(id).stream().map((Cat friend) -> catMapper.mapGetCatDto(friend)).toList();
        return catDto;
    }

    public List<GetCatDto> getAllCats() {
        return catRepository.findAll().stream().map(cat -> catMapper.mapGetCatDto(cat)).toList();
    }

    public FullGetCatDto addFriend(Long id, PatchCatDto patchDto) throws FriendshipAlreadyExistsException {
        Cat friend = catRepository.findById(patchDto.friendId).get();
        Cat cat = catRepository.findById(id).get();

        if (catToCatRepository.doesFriendShipExist(cat.getId(), friend.getId())) {
            throw new FriendshipAlreadyExistsException(); 
        }

        CatToCat relationship = new CatToCat();
        relationship.setCatFirst(cat);
        relationship.setCatSecond(friend);
        catToCatRepository.save(relationship);

        return this.getCatById(id);
    }
    
}
