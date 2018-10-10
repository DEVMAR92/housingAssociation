package pl.springmvc.zadanie.wspolnota.zadaniewspolnotamieszkaniowa.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Community {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String street;

    private String number;

    @OneToMany(mappedBy = "community")
    private List<Flat> flats;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Flat> getFlats() {
        return flats;
    }

    public void setFlats(List<Flat> flats) {
        this.flats = flats;
    }

    @Override
    public String toString() {
        return name + " , ul." + street + " " + number;
    }
}