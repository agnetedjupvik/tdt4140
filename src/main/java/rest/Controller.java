package rest;

import input.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/api", method = RequestMethod.GET)
    public Snapshot api() {
        return inputSimulator.getLatestDataPoints();
    }

}
