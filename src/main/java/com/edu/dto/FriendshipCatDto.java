package com.edu.dto;

import jakarta.validation.constraints.NotEmpty;


public class FriendshipCatDto {
    @NotEmpty
    public Long friendId;

    @Override
    public String toString(){
        return String.format("FriendshipCatDto: friendId=%d", friendId);
    }
}