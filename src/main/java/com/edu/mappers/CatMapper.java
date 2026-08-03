
package com.edu.mappers;

import org.springframework.stereotype.Service;
import com.edu.entities.Color;
import com.edu.exceptions.InvalidBirthdateException;
import com.edu.services.DateParser;
import com.edu.entities.Cat;
import com.edu.dto.CreateCatDto;
import com.edu.dto.GetCatDto;
import com.edu.dto.FullGetCatDto;

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
        try {
            cat.setBirthdate(DateParser.dateToSqlDate(dto.birthdate));
        }
        catch (IllegalArgumentException e) {
            throw new InvalidBirthdateException();
        }
        
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