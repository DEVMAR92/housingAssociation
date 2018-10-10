package pl.springmvc.zadanie.wspolnota.zadaniewspolnotamieszkaniowa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.springmvc.zadanie.wspolnota.zadaniewspolnotamieszkaniowa.interfaces.CommunityRepository;
import pl.springmvc.zadanie.wspolnota.zadaniewspolnotamieszkaniowa.interfaces.OccupantReporitory;
import pl.springmvc.zadanie.wspolnota.zadaniewspolnotamieszkaniowa.model.Community;
import pl.springmvc.zadanie.wspolnota.zadaniewspolnotamieszkaniowa.model.Flat;
import pl.springmvc.zadanie.wspolnota.zadaniewspolnotamieszkaniowa.interfaces.FlatRepository;
import pl.springmvc.zadanie.wspolnota.zadaniewspolnotamieszkaniowa.model.Occupant;

import java.util.List;

@Controller
public class HomeController {

   private CommunityRepository communityRepository;
   private FlatRepository flatRepository;
   private OccupantReporitory occupantReporitory;


    public HomeController(CommunityRepository communityRepository, FlatRepository flatRepository, OccupantReporitory occupantReporitory) {
        this.communityRepository = communityRepository;
        this.flatRepository = flatRepository;
        this.occupantReporitory = occupantReporitory;
    }

    @GetMapping("/")
    public String start(Model model) {

        List<Community> communities = communityRepository.findAll();
        List<Flat> flats = flatRepository.findAll();
        List<Occupant> occupants = occupantReporitory.findAll();


        model.addAttribute("communities", communities);
        model.addAttribute("flats", flats);
        model.addAttribute("occupants", occupants);

        return "homepage";
    }

    @GetMapping("/lokatorzy")
    public String occupantsList(Model model){
        List<Occupant> occupants = occupantReporitory.findAll();

        model.addAttribute("occupants", occupants);

        return "occupants-list";
    }

    @GetMapping("/lokale")
    public String flatsList(Model model){
        List<Flat> flats = flatRepository.findAll();

        model.addAttribute("flats", flats);

        return "flats-list";
    }

    @GetMapping("/spoldzielnie")
    public String communitiesList(Model model){
        List<Community> communities = communityRepository.findAll();

        model.addAttribute("communities", communities);

        return "communities-list";
    }

}
