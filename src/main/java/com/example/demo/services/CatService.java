package com.example.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.sql.Date;

import com.example.entities.Cat;
import com.example.entities.CatToCat;

import com.example.repositories.CatRepository;
import com.example.repositories.CatToCatRepository;
import com.example.repositories.OwnerRepository;


import com.example.mappers.CatMapper;

import com.example.dto.CreateCatDto;
import com.example.dto.GetCatDto;
import com.example.dto.FullGetCatDto;
import com.example.dto.FriendshipCatDto;
import com.example.dto.GetFriendshipCatDto;


import com.example.exceptions.FriendshipAlreadyExistsException;
import com.example.exceptions.CannotBeFriendWithItselfException;

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
        var catReturnDto = catMapper.mapFullGetCatDto(catRepository.save(cat));
        catReturnDto.friends = getFriendsOfCat(catReturnDto.id);
        return catReturnDto;
    }

    public FullGetCatDto getCatById(Long id){
        var catDto = catMapper.mapFullGetCatDto(catRepository.findById(id).get());
        catDto.friends = getFriendsOfCat(id);
        return catDto;
    }

    public List<GetCatDto> getAllCats() {
        return catRepository.findAll().stream().map(cat -> catMapper.mapGetCatDto(cat)).toList();
    }

    public FullGetCatDto addFriend(Long id, Long friendId) throws FriendshipAlreadyExistsException, CannotBeFriendWithItselfException {
        Cat cat = catRepository.findById(id).get();
        Cat friend = catRepository.findById(friendId).get();

        if (cat.getId() == friend.getId()){
            throw new CannotBeFriendWithItselfException(); 
        }

        if (catToCatRepository.doesFriendShipExist(cat.getId(), friend.getId())) {
            throw new FriendshipAlreadyExistsException(); 
        }

        CatToCat relationship = new CatToCat();
        relationship.setCatFirst(cat);
        relationship.setCatSecond(friend);
        relationship.setCreatedAt(new Date((new java.util.Date()).getTime()));
        CatToCat result = catToCatRepository.save(relationship);

        System.out.printf("\nCatToCat id is %d\n", result.getId());
        return this.getCatById(id);
    }

    public GetFriendshipCatDto removeFriend(Long id, Long friendId){
        Cat cat = catRepository.findById(id).get();
        Cat friend = catRepository.findById(friendId).get();
        var relationshipRecords = catToCatRepository.getCatToCatRecords(id, friendId);
        if (relationshipRecords.size() != 1){
            throw new IllegalStateException();
        }
        var relationshipRecord = relationshipRecords.get(0);        
        catToCatRepository.deleteById(relationshipRecord.getId());
        
        var dto = new GetFriendshipCatDto();
        dto.catId = relationshipRecord.getCatFirst().getId();
        dto.catName = relationshipRecord.getCatFirst().getName();
        dto.friendId = relationshipRecord.getCatSecond().getId();
        dto.friendName = relationshipRecord.getCatSecond().getName();
        return dto;
    }

    private List<GetCatDto> getFriendsOfCat(Long id){
        return catToCatRepository.findFriendsOfCat(id).stream().map((Cat friend) -> catMapper.mapGetCatDto(friend)).toList();
    }   
}
