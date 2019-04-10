package edu.kea.cats.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class CatController {

    @GetMapping(name = "/")
    public String catGreeting() {
        return "meow";
    }

}



