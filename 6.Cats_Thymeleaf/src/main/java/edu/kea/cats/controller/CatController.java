package edu.kea.cats.controller;

import edu.kea.cats.model.Cat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Controller
public class CatController {

    @GetMapping(name = "/")
    public String showHomePage() {
        getURL();
        return "index.html";
    }

    @GetMapping("/profile")
    public String showProfile(Model model) {
        Cat modelCat = new Cat(2, "Karl Marx", "");
        model.addAttribute("cat", modelCat);
        return "profile/profile.html";
    }

    public String getURL() {
        String url = "https://aws.random.cat/meow";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        System.out.println(result);
        return result;
    }

}
