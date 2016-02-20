package rest;

import input.InputSimulator;
import input.Speedpoint;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    InputSimulator inputSimulator = new InputSimulator("src/main/resources/downtown-crosstown.json");

    @RequestMapping("/")
    public Speedpoint greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return inputSimulator.getLatestSpeedpoint();
    }
}
