package Project.TQS_AirQuality.Controllers;

import Project.TQS_AirQuality.Models.Weather;
import Project.TQS_AirQuality.Services.WeatherbitAPIService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AirQualityController.class)
class AirQualityControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private WeatherbitAPIService service;

    private List<String> cities;

    @BeforeEach
    public void setup(){
        cities = new ArrayList<>();
        cities.add("Porto");
        cities.add("Aveiro");
    }

    @Test
    public void givenCities_getCitiesJSON() throws Exception{
        given(service.getCities()).willReturn(cities);
        mvc.perform(get("/airQuality/cities")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0]", is("Porto")))
                .andExpect(jsonPath("$[1]", is("Aveiro")));
    }

    @Test
    public void givenStats_getStatsJson() throws Exception{

        HashMap<String, String> statistics = new HashMap<>();
        statistics.put("hit", "2");
        statistics.put("miss", "2");
        statistics.put("cities", cities.toString());

        given(service.getStatistics()).willReturn(statistics);
        mvc.perform(get("/airQuality/stats")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.miss", is(statistics.get("miss"))))
                .andExpect(jsonPath("$.hit", is(statistics.get("hit"))))
                .andExpect(jsonPath("$.cities", is(statistics.get("cities"))));
    }

    @Test
    public void givenCity_getCityJson() throws Exception{
        Weather[] weathers = new Weather[1];
        Weather cityWeather = new Weather();
        cityWeather.setCity_name("Porto");
        cityWeather.setAqi(1.1);
        cityWeather.setSo2(1.1);
        cityWeather.setCo(1.1);
        cityWeather.setMold_level(1);
        cityWeather.setNo2(1.1);
        cityWeather.setO3(1.1);
        cityWeather.setPm10(1.1);
        cityWeather.setPm25(1.1);
        cityWeather.setPollen_level_grass(2);
        cityWeather.setPollen_level_tree(1);
        cityWeather.setPollen_level_weed(1);
        cityWeather.setPredominant_pollen_type("grass");
        weathers[0] = cityWeather;

        given(service.getAirQuality("Porto")).willReturn(weathers);
        mvc.perform(get("/airQuality/Porto")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].city_name", is(cityWeather.getCity_name())))
                .andExpect(jsonPath("$[0].aqi", is(cityWeather.getAqi())))
                .andExpect(jsonPath("$[0].co", is(cityWeather.getCo())))
                .andExpect(jsonPath("$[0].mold_level", is(cityWeather.getMold_level())))
                .andExpect(jsonPath("$[0].so2", is(cityWeather.getSo2())))
                .andExpect(jsonPath("$[0].predominant_pollen_type", is(cityWeather.getPredominant_pollen_type())))
                .andExpect(jsonPath("$[0].o3", is(cityWeather.getO3())))
                .andExpect(jsonPath("$[0].no2", is(cityWeather.getNo2())))
                .andExpect(jsonPath("$[0].pm10", is(cityWeather.getPm10())))
                .andExpect(jsonPath("$[0].pm25", is(cityWeather.getPm25())))
                .andExpect(jsonPath("$[0].pollen_level_grass", is(cityWeather.getPollen_level_grass())))
                .andExpect(jsonPath("$[0].pollen_level_weed", is(cityWeather.getPollen_level_weed())))
                .andExpect(jsonPath("$[0].pollen_level_tree", is(cityWeather.getPollen_level_tree())));
    }
}