package com.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import java.sql.Date;

import com.example.entities.Cat;

@Entity
@Table(name="cat_to_cat")
public class CatToCat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // or IDENTITY, SEQUENCE
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cat_first_id")
    private Cat catFirst;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cat_second_id")
    private Cat catSecond;

    @Column(name="created_at")
    Date createdAt;


    public CatToCat(){}

    public Long getId(){
        return id;
    }
    public Cat getCatFirst(){
        return catFirst;
    }
    public void setCatFirst(Cat cat){
        catFirst = cat;
    }
    public Cat getCatSecond(){
        return catSecond;
    }
    public void setCatSecond(Cat cat){
        catSecond = cat;
    }
    public Date getCreatedAt(){
        return createdAt;
    }
    public void setCreatedAt(Date createdAt){
        this.createdAt = createdAt;
    }
}