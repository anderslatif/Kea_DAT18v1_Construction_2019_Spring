package kea;

import org.springframework.web.bind.annotation.*;


@RestController
public class GameController {

    @GetMapping(value = "/game/{weapon}")
    public String rockScissorsPaperGame(@PathVariable String weapon) {
        if (!weapon.equalsIgnoreCase("rock") &&
                !weapon.equalsIgnoreCase("scissors") && !weapon.equalsIgnoreCase("paper")) {
            return "Unknown choice of weapon";
        }
        String[] availableChoices = new String[3];
        availableChoices[0] = "rock";
        availableChoices[1] = "scissors";
        availableChoices[2] = "paper";

        String computerchoice = availableChoices[(int) (Math.random() * 3)];
        String response = "Your choice was: " + weapon + " And the computer chose " + computerchoice + ". ";

        if (weapon.equals(computerchoice)) {
            return response + "You tied";
        } else if(weapon.equalsIgnoreCase("rock") && computerchoice.equalsIgnoreCase("scissors")) {
            return response + "You won";
        } else if (weapon.equalsIgnoreCase("scissors") && computerchoice.equalsIgnoreCase("paper")) {
            return response + "You won";
        } else if (weapon.equalsIgnoreCase("paper") && computerchoice.equalsIgnoreCase("rock")) {
            return response + "You won";
        } else {
            return response + "You lost";
        }
    }

}
