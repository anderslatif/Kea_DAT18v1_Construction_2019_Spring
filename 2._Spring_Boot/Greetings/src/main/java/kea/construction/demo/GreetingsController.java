package kea.construction.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingsController {

    @RequestMapping(value = "/greetings", method = RequestMethod.GET)
    public String greetings(@RequestParam(value = "name", required = false) String name) {
        if (name == null) {
            return "who are you?";
        } else {
            System.out.println(name);
            return "hello " + name;
        }
    }

    @RequestMapping(value = "/greetings/{personId}", method = RequestMethod.GET)
    public String mingleWithPerson(@PathVariable Integer personId) {
        switch (personId) {
            case 0: return "Magnus";
            case 1: return "Jens";
            case 2: return "Adam";
            default: return "Anders";
        }
    }

    @RequestMapping(value = "/getBody", method = RequestMethod.POST)
    public String getBody(@RequestBody String body) {
        return body;
    }



}
