package entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cats")
public class Cat {

    @Id
    @GeneratedValue
    private int id;

    @ManyToMany(targetEntity = Cat.class)
    @JoinTable(name = "cats_friends",
            // "<!--noformat-->"
            joinColumns = { @JoinColumn(name = "first_id", referencedColumnName = "id") },
            // "<!--noformat-->"
            inverseJoinColumns = { @JoinColumn(name = "second_id", referencedColumnName = "id") })
    private List<Cat> friends;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date birthDate;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Breed breed;

    @ManyToOne(targetEntity = Owner.class)
    @JoinColumn(name = "owner", nullable = true)
    private Owner owner;

    public Cat() {
        friends = new ArrayList<>();
    }

    public Cat(String name, Date birthDate, Owner owner, Breed breed) {
        this.name = name;
        this.birthDate = birthDate;
        this.owner = owner;
        this.breed = breed;
        this.friends = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Cat> getFriends() {
        return friends;
    }

    public void setFriends(List<Cat> friends) {
        this.friends = friends;
    }
}