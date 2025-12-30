package com.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;
import java.sql.Date;

import java.util.List;

@Entity
@Table(name="owners")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // or IDENTITY, SEQUENCE
    private Long id;

    @Column
    private String name;

    @Column
    private Date birthdate;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cat> cats;
    public Owner(){}
    public Long getId(){
        return this.id;
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
    public List<Cat> getCats(){
        return cats;
    }
    public void setCats(List<Cat> cats){
        this.cats = cats;
    }
    public void addCat(Cat cat){
        cats.add(cat);
    }
    public void removeCat(Cat cat){
        cats.remove(cat);
    }
}