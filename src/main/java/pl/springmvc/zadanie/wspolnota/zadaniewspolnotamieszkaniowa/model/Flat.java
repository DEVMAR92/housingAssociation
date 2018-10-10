package pl.springmvc.zadanie.wspolnota.zadaniewspolnotamieszkaniowa.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Flat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int number;

    private double area;

    @OneToMany(mappedBy="flat")
    private List<Occupant> occupants;

    @ManyToOne
    private Community community;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public List<Occupant> getOccupants() {
        return occupants;
    }

    public void setOccupants(List<Occupant> occupants) {
        this.occupants = occupants;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    @Override
    public String toString() {
        return number + ", " + area + " m2 ";
    }
}
