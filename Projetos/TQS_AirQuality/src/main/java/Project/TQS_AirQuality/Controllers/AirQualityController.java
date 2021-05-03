package Project.TQS_AirQuality.Controllers;

import Project.TQS_AirQuality.Models.Response;
import Project.TQS_AirQuality.Models.Weather;
import Project.TQS_AirQuality.Services.WeatherbitAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/airQuality")
public class AirQualityController {

    @Autowired
    private WeatherbitAPIService service;

    @GetMapping("/cities")
    public List<String> getCities() {
        return service.getCities();
    }

    @GetMapping("/stats")
    public Map<String, String> getStatistics() {
        return service.getStatistics();
    }

    @GetMapping("/{city}")
    public Weather[] getCityAirQuality(@PathVariable(value = "city") String city) {
        return service.getAirQuality(city);
    }
}