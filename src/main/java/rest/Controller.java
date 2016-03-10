package rest;

import input.Snapshot;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controller {

    @RequestMapping("/")
    public ModelAndView rootRedirect() {
        return new ModelAndView("redirect:/speedometer.html");
    }

    @RequestMapping(value = "/api", method = RequestMethod.GET)
    public Snapshot api() {
        return Application.inputSimulator.getLatestDataPoints();
    }

}