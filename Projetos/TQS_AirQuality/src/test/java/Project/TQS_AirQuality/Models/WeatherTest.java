package Project.TQS_AirQuality.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherTest {

    private Weather w;

    @BeforeEach
    void setup(){
        w = new Weather();
    }

    @Test
    void setMoldLevel_getMoldLevel(){
        w.setMold_level(1);
        assertEquals(1, w.getMold_level());
    }

    @Test
    void setAqi_getAqi(){
        w.setAqi(1.1);
        assertEquals(1.1, w.getAqi());
    }

    @Test
    void setPm25_getPm25(){
        w.setPm25(1.1);
        assertEquals(1.1, w.getPm25());
    }

    @Test
    void setPredominant_pollen_type_getPredominant_pollen_type(){
        w.setPredominant_pollen_type("grass");
        assertEquals("grass" , w.getPredominant_pollen_type());
    }

    @Test
    void setSo2_getSo2(){
        w.setSo2(1.1);
        assertEquals(1.1, w.getSo2());
    }

    @Test
    void setPm10_getPm10(){
        w.setPm10(1.1);
        assertEquals(1.1, w.getPm10());
    }

    @Test
    void setCo_getCo(){
        w.setCo(1.1);
        assertEquals(1.1, w.getCo());
    }

    @Test
    void setNo2_getNo2(){
        w.setNo2(1.1);
        assertEquals(1.1, w.getNo2());
    }

    @Test
    void setO3_getO3(){
        w.setO3(1.1);
        assertEquals(1.1, w.getO3());
    }

    @Test
    void setPollen_level_weed_getPollen_level_weed(){
        w.setPollen_level_weed(1);
        assertEquals(1, w.getPollen_level_weed());
    }

    @Test
    void setPollen_level_grass_getPollen_level_grass(){
        w.setPollen_level_grass(1);
        assertEquals(1, w.getPollen_level_grass());
    }

    @Test
    void setPollen_level_tree_getPollen_level_tree(){
        w.setPollen_level_tree(1);
        assertEquals(1, w.getPollen_level_tree());
    }

    @Test
    void setCity_name_getCity_name(){
        w.setCity_name("Porto");
        assertEquals("Porto", w.getCity_name());
    }
}