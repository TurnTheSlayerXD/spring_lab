package entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "owners")
public class Owner {

    @Id
    @GeneratedValue()
    private int id;
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "owner")
    private List<Cat> cats;

    @Column(nullable = false)
    private Date birthDate;

    public Owner() {
        cats = new ArrayList<>();
    }

    public Owner(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.cats = new ArrayList<>();
    }

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
        return cats;
    }

    public void setOwned(List<Cat> cats) {
        this.cats = cats;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

}
