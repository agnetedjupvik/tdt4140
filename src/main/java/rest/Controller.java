package rest;

import input.InputSimulator;
import input.Speedpoint;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controller {

    InputSimulator inputSimulator = new InputSimulator("downtown-crosstown.json");

    @RequestMapping("/")
    public ModelAndView rootRedirect() {
        return new ModelAndView("redirect:/speedometer.html");
    }

    @RequestMapping("/api")
    public Speedpoint greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return inputSimulator.getLatestSpeedpoint();
    }
}
