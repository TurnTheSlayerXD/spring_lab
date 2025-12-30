
package com.example.mappers;

import org.springframework.stereotype.Service;
import java.sql.Date;

import com.example.entities.Color;
import com.example.entities.Cat;
import com.example.dto.CreateCatDto;
import com.example.dto.GetCatDto;
import com.example.dto.FullGetCatDto;

@Service
public class CatMapper {
    
    public FullGetCatDto mapFullGetCatDto(Cat cat){
        FullGetCatDto catDto = new FullGetCatDto();
        catDto.id = cat.getId();
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
        dto.ownerId = cat.getOwner().getId();
        return dto;
    }

    public Cat mapCreateCatDto(CreateCatDto dto){
        Cat cat = new Cat();
        cat.setName(dto.name);
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
            default: 
                throw new UnsupportedOperationException("No color set");
        }
        cat.setColor(color);
        return cat;
    }
}