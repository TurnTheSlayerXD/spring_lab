
package com.example.mappers;

import java.sql.Date;

import com.example.entities.Color;
import com.example.entities.Cat;
import com.example.dto.CreateCatDto;
import com.example.dto.GetCatDto;
import com.example.dto.FullGetCatDto;

public class CatMapper {
    
    public FullGetCatDto mapFullGetCatDto(Cat cat){
        FullGetCatDto catDto = new FullGetCatDto();
        catDto.name = cat.getName();
        catDto.birthdate = cat.getBirthdate().toString();
        catDto.breed = cat.getBreed();
        catDto.color = cat.getColor().toString();
        catDto.ownerId = cat.getOwner().getId();
        return catDto;
    }

    public GetCatDto mapGetCatDto(Cat cat){
        GetCatDto dto = new GetCatDto();
        dto.id = cat.getId();
        dto.name = cat.getName();
        return dto;
    }

    public Cat mapCreateCatDto(CreateCatDto dto){
        Cat cat = new Cat();
        cat.setBirthdate(Date.valueOf(dto.birthdate));
        cat.setBreed(dto.breed);
        Color color;
        switch(dto.color) {
            case "red":
                color = Color.RED;
                break;
            case "blue":
                color = Color.BLUE;
                break;
            case "yellow":
                color = Color.YELLOW;
                break;
            case "white":
                color = Color.WHITE;
                break;
            case "black":
                color = Color.BLACK;
                break;
        }
        cat.setColor(color);
        return cat;
    }
}