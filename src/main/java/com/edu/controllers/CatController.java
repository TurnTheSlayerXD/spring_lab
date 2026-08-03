package com.edu.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

import java.util.List;

import com.edu.services.CatService;
import com.edu.dto.GetCatDto;
import com.edu.dto.FullGetCatDto;
import com.edu.dto.CreateCatDto;
import com.edu.dto.FriendshipCatDto;
import com.edu.dto.GetFriendshipCatDto;

import com.edu.exceptions.FriendshipAlreadyExistsException;
import com.edu.exceptions.CannotBeFriendWithItselfException;

@RestController
public class CatController {

    private CatService catService;
    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping("/list/cats")
    public List<GetCatDto> list() {
        return catService.getAllCats();
    }

    @PostMapping("/record/cats")
    public FullGetCatDto create(@Valid @RequestBody CreateCatDto catDto) {
        System.out.printf("%s", catDto.toString());
        return catService.createCat(catDto);
    }

    @GetMapping("/record/cats/{id}")
    public FullGetCatDto get(@PathVariable("id") Long id) {
        return catService.getCatById(id);
    }

    @PostMapping("/record/cats/friends/{id}")
    public FullGetCatDto addFriendship(@PathVariable("id") Long id, @Valid @RequestBody FriendshipCatDto patch)
            throws FriendshipAlreadyExistsException, CannotBeFriendWithItselfException {
        System.out.printf("%s\n", patch.toString());
        return catService.addFriend(id, patch.friendId);
    }

    @DeleteMapping("/record/cats/{id}")
    public FullGetCatDto deleteCat(@PathVariable("id") Long id) {
        return catService.deleteCat(id);
    }

    @DeleteMapping("/record/cats/friends/{id}")
    public GetFriendshipCatDto removeFriendship(@PathVariable("id") Long id, @Valid @RequestBody FriendshipCatDto friendshipDto) {
        System.out.printf("%s\n", friendshipDto.toString());
        return catService.removeFriend(id, friendshipDto.friendId);
    }

}