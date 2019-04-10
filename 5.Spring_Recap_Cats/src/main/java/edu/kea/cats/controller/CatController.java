package edu.kea.cats.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class CatController {

    @GetMapping(name = "/")
    public String showHomePage() {
        return "index.html";
    }

    @GetMapping("/profile")
    public String showProfile(Model model) {
        return "profile/profile-page.html";
    }

    @GetMapping("/test")
    public @ResponseBody String tryTest() {
        return "test works... nice one";
    }


}



