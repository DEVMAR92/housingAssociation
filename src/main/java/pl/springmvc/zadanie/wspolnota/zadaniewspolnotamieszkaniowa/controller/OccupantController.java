package pl.springmvc.zadanie.wspolnota.zadaniewspolnotamieszkaniowa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.springmvc.zadanie.wspolnota.zadaniewspolnotamieszkaniowa.interfaces.FlatRepository;
import pl.springmvc.zadanie.wspolnota.zadaniewspolnotamieszkaniowa.interfaces.OccupantReporitory;
import pl.springmvc.zadanie.wspolnota.zadaniewspolnotamieszkaniowa.model.Community;
import pl.springmvc.zadanie.wspolnota.zadaniewspolnotamieszkaniowa.model.Flat;
import pl.springmvc.zadanie.wspolnota.zadaniewspolnotamieszkaniowa.model.Occupant;

import java.util.List;
import java.util.Optional;

@Controller
public class OccupantController {

    private OccupantReporitory occupantReporitory;
    private FlatRepository flatRepository;

    public OccupantController(OccupantReporitory occupantReporitory, FlatRepository flatRepository) {
        this.occupantReporitory = occupantReporitory;
        this.flatRepository = flatRepository;
    }

    @GetMapping("/lokator/{id}")
    public String getOccupantSpec(@PathVariable Long id,
                                  Model model) {
        Optional<Occupant> byId = occupantReporitory.findById(id);
        if (byId.isPresent()) {
            Occupant occupant = byId.get();
            model.addAttribute("occupant", occupant);
        }
        return "/occupants";
    }

    @GetMapping("/lokator-dodaj")
    public String addOccupant(Model model) {

        List<Flat> all = flatRepository.findAll();

        model.addAttribute("occupant", new Occupant());
        model.addAttribute("fl", all);

        return "occupants-add";

    }

    @PostMapping("/lokator-dodaj")
    public String addOccupantPost(Occupant occupant) {
        occupantReporitory.save(occupant);

        return "redirect:/lokatorzy";
    }

    @GetMapping("/lokator-edytuj/{id}")
    public String editOccupant(@PathVariable Long id,
                               Model model) {
        Optional<Occupant> byId = occupantReporitory.findById(id);
        List<Flat> all = flatRepository.findAll();
        if (byId.isPresent()) {
            model.addAttribute("occupant", byId);
        }
        model.addAttribute("fl", all);
        return "occupants-edit";
    }

    @PostMapping("/lokator-edytuj")
    public String editOccupantPost(Occupant occupant) {
        occupantReporitory.save(occupant);
        return "redirect:/lokatorzy";
    }

    @GetMapping("/lokator-usun/{id}")
    public String deleteFlat(@PathVariable Long id) {

        Optional<Occupant> byId = occupantReporitory.findById(id);

        if (byId.isPresent()) {
            Occupant occupant = byId.get();
            occupantReporitory.delete(occupant);

            return "redirect:/lokatorzy";
        }
        return "redirect:/error";
    }
}
