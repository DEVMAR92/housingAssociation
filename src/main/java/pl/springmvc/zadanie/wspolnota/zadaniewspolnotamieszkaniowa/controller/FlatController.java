package pl.springmvc.zadanie.wspolnota.zadaniewspolnotamieszkaniowa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.springmvc.zadanie.wspolnota.zadaniewspolnotamieszkaniowa.model.Community;
import pl.springmvc.zadanie.wspolnota.zadaniewspolnotamieszkaniowa.interfaces.CommunityRepository;
import pl.springmvc.zadanie.wspolnota.zadaniewspolnotamieszkaniowa.model.Flat;
import pl.springmvc.zadanie.wspolnota.zadaniewspolnotamieszkaniowa.interfaces.FlatRepository;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Controller
public class FlatController {

    private FlatRepository flatRepository;
    private CommunityRepository communityRepository;

    public FlatController(FlatRepository flatRepository, CommunityRepository communityRepository) {
        this.flatRepository = flatRepository;
        this.communityRepository = communityRepository;
    }

    @GetMapping("/lokal/{id}")
    public String getFlatSpec(@PathVariable Long id,
                                  Model model) {
        Optional<Flat> byId = flatRepository.findById(id);
        if(byId.isPresent()) {
            Flat flat = byId.get();
            model.addAttribute("flat", flat);
            return "/flats";
        }
        return "redirect:/error";
    }

    @GetMapping("/lokal-dodaj")
    public String addFlat(Model model){

        List<Community> all = communityRepository.findAll();

        model.addAttribute("flat", new Flat());
        model.addAttribute("comm", all);

        return "flats-add";

    }
    @PostMapping("/lokal-dodaj")
    public String addFlatPost(Flat flat){

        flatRepository.save(flat);

        return "redirect:/lokale";
    }

    @GetMapping("/lokal-edytuj/{id}")
    public String editFlat(@PathVariable Long id,
                                Model model) {
        Optional<Flat> byId = flatRepository.findById(id);
        List<Community> all = communityRepository.findAll();

        if(byId.isPresent()){
            model.addAttribute("flat", byId);
        }
        model.addAttribute("comm", all);
        return "flats-edit";
    }

    @PostMapping("/lokal-edytuj")
    public String editFlatPost(Flat flat) {
        flatRepository.save(flat);
        return "redirect:/lokale";
    }

    @GetMapping("/lokal-usun/{id}")
    public String deleteFlat(@PathVariable Long id){

        Optional<Flat> byId = flatRepository.findById(id);
        if(byId.isPresent()){
            Flat flat = byId.get();
            if(flat.getOccupants().isEmpty()){
                flatRepository.delete(flat);
                return "redirect:/lokale";
            }
        }
        return "redirect:/error";
    }
}
