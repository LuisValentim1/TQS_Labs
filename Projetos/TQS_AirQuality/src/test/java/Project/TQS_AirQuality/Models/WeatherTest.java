package Project.TQS_AirQuality.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class WeatherTest {

    private Weather w;

    @BeforeEach
    public void setup(){
        w = new Weather();
    }

    @Test
    public void setMoldLevel_getMoldLevel(){
        w.setMold_level(1);
        assertEquals(1, w.getMold_level());
    }

    @Test
    public void setAqi_getAqi(){
        w.setAqi(1.1);
        assertEquals(1.1, w.getAqi());
    }

    @Test
    public void setPm25_getPm25(){
        w.setPm25(1.1);
        assertEquals(1.1, w.getPm25());
    }

    @Test
    public void setPredominant_pollen_type_getPredominant_pollen_type(){
        w.setPredominant_pollen_type("grass");
        assertEquals("grass" , w.getPredominant_pollen_type());
    }

    @Test
    public void setSo2_getSo2(){
        w.setSo2(1.1);
        assertEquals(1.1, w.getSo2());
    }

    @Test
    public void setPm10_getPm10(){
        w.setPm10(1.1);
        assertEquals(1.1, w.getPm10());
    }

    @Test
    public void setCo_getCo(){
        w.setCo(1.1);
        assertEquals(1.1, w.getCo());
    }

    @Test
    public void setNo2_getNo2(){
        w.setNo2(1.1);
        assertEquals(1.1, w.getNo2());
    }

    @Test
    public void setO3_getO3(){
        w.setO3(1.1);
        assertEquals(1.1, w.getO3());
    }

    @Test
    public void setPollen_level_weed_getPollen_level_weed(){
        w.setPollen_level_weed(1);
        assertEquals(1, w.getPollen_level_weed());
    }

    @Test
    public void setPollen_level_grass_getPollen_level_grass(){
        w.setPollen_level_grass(1);
        assertEquals(1, w.getPollen_level_grass());
    }

    @Test
    public void setPollen_level_tree_getPollen_level_tree(){
        w.setPollen_level_tree(1);
        assertEquals(1, w.getPollen_level_tree());
    }

    @Test
    public void setCity_name_getCity_name(){
        w.setCity_name("Porto");
        assertEquals("Porto", w.getCity_name());
    }
}