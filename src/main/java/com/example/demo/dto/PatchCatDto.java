package com.example.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;


public class PatchCatDto {
    @NotEmpty
    @Pattern(regexp="add_friend|remove_friend")
    public String action;

    @NotEmpty
    public Long friendId;

}