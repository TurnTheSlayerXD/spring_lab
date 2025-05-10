package dto;

import java.util.Date;
import java.util.List;

public class GetOwnerDto {
    String name;
    List<Integer> cats;
    Date birthDate;


    public GetOwnerDto(String name,
                       Date birthDate,
                       List<Integer> cats
                       ) {
        this.name = name;
        this.cats = cats;
        this.birthDate = birthDate;
    }
}