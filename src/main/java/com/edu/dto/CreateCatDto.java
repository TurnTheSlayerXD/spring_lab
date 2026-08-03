package com.edu.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

public class CreateCatDto {

    @NotEmpty
    public String name;
    
    @NotEmpty
    @PastOrPresent
    public String birthdate;

    @NotEmpty
    public String breed;

    @NotEmpty
    @Pattern(regexp = "red|blue|yellow|white|black")
    public String color;

    @NotEmpty
    public Long ownerId;
}