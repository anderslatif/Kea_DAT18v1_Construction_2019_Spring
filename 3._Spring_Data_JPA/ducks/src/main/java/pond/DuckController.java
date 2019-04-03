package pond;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/quack")
public class DuckController {

    @Autowired
    private DuckRepository duckRepository;

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



}
