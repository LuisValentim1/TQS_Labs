package Project.TQS_AirQuality.Services;

import Project.TQS_AirQuality.Cache.Cache;
import Project.TQS_AirQuality.Models.Response;
import Project.TQS_AirQuality.Models.Weather;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Timestamp;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class WeatherbitAPIServiceTest {

    @Mock
    private Cache c;

    @InjectMocks
    private WeatherbitAPIService service;

    private List<String> cities;
    private HashMap<String, String> stats;
    private Response porto;

    @BeforeEach
    public void setUp() {

        cities = new ArrayList<>();
        cities.add("Aveiro");
        cities.add("Porto");

        stats = new HashMap<>();
        stats.put("hit", Integer.toString(2));
        stats.put("miss", Integer.toString(1));
        stats.put("cityInfo", cities.toString());

        Weather weather = new Weather();
        weather.setCity_name("Porto");
        weather.setAqi(1.1);
        weather.setSo2(1.1);
        weather.setCo(1.1);
        weather.setMold_level(1);
        weather.setNo2(1.1);
        weather.setO3(1.1);
        weather.setPm10(1.1);
        weather.setPm25(1.1);
        weather.setPollen_level_grass(2);
        weather.setPollen_level_tree(1);
        weather.setPollen_level_weed(1);
        weather.setPredominant_pollen_type("grass");
        Weather[] airInfo = {weather};

        long timestamp = new Timestamp(System.currentTimeMillis()).getTime();
        porto = new Response();
        porto.setData(airInfo);
        porto.setTimestamp(timestamp);
    }

    @Test
    public void givenCities_whenGetCities_thenReturn() {
        String city1 ="Porto";
        String city2 ="Aveiro";

        Mockito.when(c.getCities()).thenReturn(cities);

        List<String> citiesReturn = service.getCities();
        assertThat(citiesReturn)
                .hasSize(2)
                .extracting(String::toString)
                .contains(city1, city2);
    }

    @Test
    public void givenStatistics_whenGetStatistics_thenReturn() {
        int hits = 2;
        int misses = 1;
        List<String> citiesReturn = Arrays.asList("Aveiro", "Porto");

        Mockito.when(c.getStats()).thenReturn(stats);

        Map<String, String> stats = service.getStatistics();

        assertThat(stats)
                .hasSize(3)
                .containsKeys("hit", "miss", "cityInfo")
                .containsValues(String.valueOf(hits), String.valueOf(misses), citiesReturn.toString());
    }


    @Test
    public void whenInvalidCity_thenAirQualityInfoShouldBeNull() {
        String invalidCityName = "gotham";

        Weather[] returned = service.getAirQuality(invalidCityName);
        Weather info= service.getAirQuality(invalidCityName)[0];

        assertThat(returned)
                .hasSize(1);
        assertEquals(null, info.getAqi());
        assertEquals(null, info.getMold_level());

    }


    @Test
    public void whenValidCity_thenAirQualityInfoShouldBeReturned() {
        Mockito.when(c.getCityInfo("Porto")).thenReturn(porto);

        Weather[] returned = service.getAirQuality("Porto");
        Weather info= service.getAirQuality("Porto")[0];

        assertThat(returned)
                .hasSize(1);
        assertEquals(1.1, info.getAqi());
        assertEquals(1, info.getMold_level());
    }

}