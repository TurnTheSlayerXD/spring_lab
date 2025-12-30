package com.example.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;


public class FriendshipCatDto {
    @NotEmpty
    public Long friendId;

    @Override
    public String toString(){
        return String.format("FriendshipCatDto: friendId=%d", friendId);
    }
}