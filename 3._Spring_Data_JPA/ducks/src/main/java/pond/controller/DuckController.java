package pond.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pond.model.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(path = "/quack")
public class DuckController {

    @Autowired
    private DuckRepository duckRepository;

    @Autowired
    private PondRepository pondRepository;

    @GetMapping(path = "/add")
    public @ResponseBody String addDuck(@RequestParam String name) {
        if (name.equals("") ||  name.length() >= 255) {
            return "No ducks added";
        }
        Duck newDuck = new Duck();
        newDuck.setName(name);

        duckRepository.save(newDuck);
        return "Duck was saved!";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Duck> getDucks() {
        return duckRepository.findAll();
    }

    @GetMapping(path = "/addDuckToPond")
    public @ResponseBody String addFavoritePond(@RequestParam String name, @RequestParam String location) {
        Duck duck = new Duck();
        duck.setName(name);

        Pond pond = new Pond();
        pond.setLocation(location);

        duckRepository.save(duck);

        duck.getFavoritePonds().add(pond);

        pond.getDucks().add(duck);


        pondRepository.save(pond);

        return "Saved a duck to the pond";
    }


    @GetMapping(path = "/goose_pimping")
    public @ResponseBody String pimpMyGoose(@RequestParam String age) {
        Duck foundDuck = duckRepository.findByName("ducksie1");

        if (foundDuck == null) {
            return "Sorry, honey. No ducks found.";
        }

        PapaGoose papaGoose = new PapaGoose(Integer.parseInt(age));

        foundDuck.setSugarGoose(papaGoose);



        return null;
    }


}
