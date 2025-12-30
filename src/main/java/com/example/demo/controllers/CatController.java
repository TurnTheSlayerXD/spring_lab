package com.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

import java.util.List;


import com.example.services.CatService;
import com.example.entities.Cat;

import com.example.mappers.CatMapper;
import com.example.dto.GetCatDto;
import com.example.dto.FullGetCatDto;
import com.example.dto.CreateCatDto;
import com.example.dto.FriendshipCatDto;
import com.example.dto.GetFriendshipCatDto;


import com.example.exceptions.FriendshipAlreadyExistsException;
import com.example.exceptions.CannotBeFriendWithItselfException;

@RestController
public class CatController {

    private CatService catService; 
    private CatMapper catMapper;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping("/list/cats")
    public List<GetCatDto> list() {
        return catService.getAllCats();
    }

    @PostMapping("/record/cats")
    public FullGetCatDto create(@Valid @RequestBody CreateCatDto catDto){
        System.out.printf("%s", catDto.toString());
        return catService.createCat(catDto);
    }

    @GetMapping("/record/cats/{id}")
    public FullGetCatDto get(@PathVariable("id") Long id){
        return catService.getCatById(id);
    }

    @PostMapping("/record/cats/{id}")
    public FullGetCatDto addFriendship(@PathVariable("id") Long id, @Valid @RequestBody FriendshipCatDto patch) throws FriendshipAlreadyExistsException, CannotBeFriendWithItselfException {
        System.out.printf("%s\n", patch.toString());
        return catService.addFriend(id, patch.friendId);
    }

    @DeleteMapping("/record/cats/{id}")
    public GetFriendshipCatDto removeFriendship(@PathVariable("id") Long id, @Valid @RequestBody FriendshipCatDto patch) {
        System.out.printf("%s\n", patch.toString());
        return catService.removeFriend(id, patch.friendId);
    }
}