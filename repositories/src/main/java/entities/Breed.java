package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "breeds")
public class Breed {

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String name;

    public Breed() {
    }

    public Breed(String name) {
        this.name = name;
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

}
