package uwindsor.clinic.controllers;

import com.uwindsor.clinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owner")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }


    @RequestMapping({"","/","/index","index.html"})
    public String listOwner(Model model){
        model.addAttribute("owners", ownerService.findAll());



        System.out.println("owner service find out all " + ownerService.findAll());
        return "/owner/index";
    }
}
