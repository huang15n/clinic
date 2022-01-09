package uwindsor.clinic.controllers;

import com.uwindsor.clinic.models.Vet;
import com.uwindsor.clinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("vets")
public class VetController {

    private VetService vetService;


    public VetController(VetService vetService) {
        this.vetService = vetService;

    }


    @RequestMapping({"","/","index","index.html"})
    public String listVets(Model model){
        model.addAttribute("vets",vetService.findAll());


        System.out.println(vetService.findAll());
        return "/vet/index";
    }
}
