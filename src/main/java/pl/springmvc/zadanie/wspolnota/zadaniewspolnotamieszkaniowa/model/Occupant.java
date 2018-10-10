package pl.springmvc.zadanie.wspolnota.zadaniewspolnotamieszkaniowa.model;


import pl.springmvc.zadanie.wspolnota.zadaniewspolnotamieszkaniowa.model.Flat;

import javax.persistence.*;

@Entity
public class Occupant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String gender;

    @ManyToOne
    private Flat flat;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Flat getFlat() {
        return flat;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + flat;

    }
}
