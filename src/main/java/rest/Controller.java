package rest;

import input.InputSimulator;
import input.Speedpoint;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalTime;
import java.util.HashMap;

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

    @RequestMapping("/api/speedhistory")
    public HashMap speedHistory(){
        Integer[] speeds = {10, 20, 25, 20, 40, 44, 55, 0};
        String[] times = {LocalTime.of(12, 30).toString(), LocalTime.of(12, 32).toString(), LocalTime.of(12, 34).toString(), LocalTime.of(12, 36).toString(),
                LocalTime.of(12, 38).toString(), LocalTime.of(12, 40).toString(), LocalTime.of(12, 42).toString(), LocalTime.of(12, 44).toString()};
        HashMap<String, Object> map = new HashMap<>();
        map.put("speeds", speeds);
        map.put("times", times);
        return map;
    }

}
