package com.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;
import java.sql.Date;

import java.util.List;


@Entity
@Table(name="cats")
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // or IDENTITY, SEQUENCE
    private Long id;

    private String name;

    @Column
    private Date birthdate;

    @Column
    private String breed;

    @Enumerated(EnumType.STRING)
    @Column(name = "color")
    private Color color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Date getBirthdate(){
        return birthdate;
    }
    public void setBirthdate(Date birthdate){
        this.birthdate = birthdate;
    }
    public Color getColor(){
        return color;
    }
    public void setColor(Color color){
        this.color = color;
    }
    public Owner getOwner(){
        return owner;
    }
    public void setOwner(Owner owner){
        this.owner = owner;
    }
    
    public String getBreed(){
        return breed;
    }
    public void setBreed(String breed){
        this.breed = breed;
    }
}