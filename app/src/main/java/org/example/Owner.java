package org.example;

import java.util.Date;
import java.util.List;

import javax.annotation.processing.Generated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name = "owners")
public class Owner {

    @Id
    @GeneratedValue()
    public Integer id;
    @Column
    public String name;
    @Column
    public List<Cat> owned;
    @Column
    public Date birthDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cat> getOwned() {
        return owned;
    }

    public void setOwned(List<Cat> owned) {
        this.owned = owned;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

}
