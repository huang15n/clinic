package uwindsor.clinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {

    @RequestMapping(value={"","/","index.html","/index"})
    public String index(){

        return "index";
    }



}
