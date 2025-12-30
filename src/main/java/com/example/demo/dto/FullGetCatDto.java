package com.example.dto;

import java.util.List;

public class FullGetCatDto {
    public Long id;
    public Long ownerId; 
    public String name;
    public String birthdate;
    public String breed;
    public String color;
    public List<GetCatDto> friends;
}
