package Project.TQS_AirQuality.Services;

import Project.TQS_AirQuality.Cache.Cache;
import Project.TQS_AirQuality.Models.Response;
import Project.TQS_AirQuality.Models.Weather;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Map;

@Service
public class WeatherbitAPIService{

    Cache cache = new Cache();

    private static final String urlStarter = "http://api.weatherbit.io/v2.0/current/airquality?city=";

    public void saveCity(String city) {
        cache.addCity(city);
    }

    public List<String> getCities() {
        return cache.getCities();
    }

    public Map<String, String> getStatistics() {
        return cache.getStats();
    }

    public void saveAirInfo(String city, Response info) {
        cache.setCityInfo(city, info);
    }

    public Weather[] getAirQuality(String city) {
        if (!cache.exists(city.toLowerCase())) {
            RestTemplate restTemplate = new RestTemplate();
            String finalUrl = urlStarter + city + "&country=PT&key=8844fedceca0468cb6296f574866452b";
            Response cityInfo = restTemplate.getForObject(finalUrl, Response.class);
            if (cityInfo != null) {
                cache.setMiss();
                this.saveCity(city);
                this.saveAirInfo(city, cityInfo);
                return cache.getCityInfo(city).getData();
            }
            else
                return new Weather[] {new Weather()};
        }
        // valid value just do get
        else {
            cache.setHit();
            return cache.getCityInfo(city).getData();
        }

    }
}
