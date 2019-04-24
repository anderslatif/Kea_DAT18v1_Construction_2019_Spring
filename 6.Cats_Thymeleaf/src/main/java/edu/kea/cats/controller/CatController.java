package edu.kea.cats.controller;

import edu.kea.cats.model.Cat;
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
        Cat modelCat = new Cat(2, "Karl Marx", "");
        model.addAttribute("cat", modelCat);
        return "profile/profile.html";
    }

}
