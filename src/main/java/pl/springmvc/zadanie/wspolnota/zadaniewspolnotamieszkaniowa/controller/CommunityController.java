package pl.springmvc.zadanie.wspolnota.zadaniewspolnotamieszkaniowa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.springmvc.zadanie.wspolnota.zadaniewspolnotamieszkaniowa.model.Community;
import pl.springmvc.zadanie.wspolnota.zadaniewspolnotamieszkaniowa.interfaces.CommunityRepository;
import pl.springmvc.zadanie.wspolnota.zadaniewspolnotamieszkaniowa.model.Flat;
import pl.springmvc.zadanie.wspolnota.zadaniewspolnotamieszkaniowa.model.Occupant;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CommunityController {

    private CommunityRepository communityRepository;

    public CommunityController(CommunityRepository communityRepository) {
        this.communityRepository = communityRepository;
    }

    @GetMapping("/spoldzielnia/{id}")
    public String getCommuntySpec(@PathVariable Long id,
                                  Model model) {
        Optional<Community> byId = communityRepository.findById(id);
        if(byId.isPresent()){
            
            Community community = byId.get();
            List<Flat> flats = community.getFlats();
            List<Occupant> occupants = new ArrayList<>();
            List<Occupant> occupantHolder;
            int flatCounter = 0;
            double areaCounter = 0;

            for (Flat flat : flats) {
                occupantHolder = flat.getOccupants();
                areaCounter += flat.getArea();
                flatCounter++;
                for (Occupant occupant : occupantHolder) {
                    occupants.add(occupant);
                }
            }
            model.addAttribute("community", community);
            model.addAttribute("occupants", occupants);
            model.addAttribute("flatCounter", flatCounter);
            model.addAttribute("areaCounter", areaCounter);
            return "/communities";
        }
       return "redirect:/error";
    }

    @GetMapping("/spoldzielnie-dodaj")
    public String addCommunity(Model model) {

        model.addAttribute("community", new Community());

        return "communities-add";

    }

    @PostMapping("/spoldzielnie-dodaj")
    public String addCommunityPost(Community community) {

        communityRepository.save(community);

        return "redirect:/spoldzielnie";
    }


    @GetMapping("/spoldzielnia-edytuj/{id}")
    public String editCommunity(@PathVariable Long id,
                                Model model) {
        Optional<Community> byId = communityRepository.findById(id);
        if(byId.isPresent()){
            model.addAttribute("community", byId);
        }
        return "communities-edit";
    }

    @PostMapping("/spoldzielnia-edytuj")
    public String editCommunityPost(Community community) {
        communityRepository.save(community);
        return "redirect:/spoldzielnie";
    }

    @GetMapping("/spoldzielnia-usun/{id}")
    public String deleteCommunity(@PathVariable Long id){

        Optional<Community> byId = communityRepository.findById(id);
        if(byId.isPresent()){
            Community community = byId.get();
            if(community.getFlats().isEmpty()){
                communityRepository.delete(community);
                return "redirect:/spoldzielnie";
            }
        }
        return "redirect:/error";
    }


}
