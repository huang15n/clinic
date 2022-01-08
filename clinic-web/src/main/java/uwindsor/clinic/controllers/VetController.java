package uwindsor.clinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    @RequestMapping({"/vet","/vet/index"})
    public String listVets(){
        return "/vet/index";
    }
}
