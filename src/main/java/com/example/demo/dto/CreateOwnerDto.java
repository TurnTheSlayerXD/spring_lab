

package com.example.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;


public class CreateOwnerDto {

    @NotEmpty
    public String name;
    
    @NotEmpty
    public String birthdate;

    @Override
    public String toString() {
        return String.format("Create Owner DTO: name=%s birthdate=%s", name, birthdate);
    }
}
