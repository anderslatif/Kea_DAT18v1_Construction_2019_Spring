package edu.kea.cats.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import edu.kea.cats.model.Cat;
import edu.kea.cats.model.CatImageResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Controller
public class CatController {

    @GetMapping(name = "/")
    public String showHomePage() {
        System.out.println(getURL());
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
        Gson gson = new Gson();
        CatImageResponse catImageResponse = gson.fromJson(result, CatImageResponse.class);
        return catImageResponse.getFile();
    }



}
