package pl.springmvc.zadanie.wspolnota.zadaniewspolnotamieszkaniowa.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.springmvc.zadanie.wspolnota.zadaniewspolnotamieszkaniowa.model.Flat;

@Repository
public interface FlatRepository extends JpaRepository<Flat, Long> {
}
