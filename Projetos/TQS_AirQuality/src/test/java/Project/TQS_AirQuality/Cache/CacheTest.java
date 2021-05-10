package Project.TQS_AirQuality.Cache;

import Project.TQS_AirQuality.Models.Response;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CacheTest {

    private Cache c;
    private Map<String, Response> cityInfo;
    private Response r;
    private Map<String, String> stats;

    @Test
    public void ifExists_returnTrue(){
        setCityInfo_getCityInfo();
        assertTrue(c.exists("Porto"));
    }

    @Test
    public void ifDoesNotExist_returnFalse(){
        setCityInfo_getCityInfo();

        assertFalse(c.exists("aveiro"));
    }

    @Test
    public void ifExistsButTimedOut_returnFalse(){
        c = new Cache();
        r = new Response();
        r.setTimestamp(0);
        c.setCityInfo("Porto", r);

        assertFalse(c.exists("Porto"));
    }

    @Test
    public void setCityInfo_getCityInfo(){
        c = new Cache();
        r = new Response();
        r.setTimestamp(new Timestamp(System.currentTimeMillis()).getTime());
        c.setCityInfo("Porto", r);

        assertEquals(r, c.getCityInfo("Porto"));
    }

    @Test
    public void setCityInfo_getCache(){
        c = new Cache();
        r = new Response();
        cityInfo = new HashMap<>();
        r.setTimestamp(new Timestamp(System.currentTimeMillis()).getTime());
        cityInfo.put("Porto", r);
        c.setCityInfo("Porto", r);

        assertEquals(cityInfo, c.getCache());
    }

    @Test
    public void getStats_returnExpectedStats(){
        c = new Cache();
        r = new Response();
        stats = new HashMap<>();

        c.addCity("Porto");

        List<String> list = c.getCities(); //Primeiro pedido bem sucedido

        r.setTimestamp(new Timestamp(System.currentTimeMillis()).getTime());
        c.setCityInfo("Porto", r);

        c.getCityInfo("Porto"); //Segunda pedido bem sucedido
        c.getCityInfo("Aveiro"); //Primeiro pedido falhado

        stats.put("hit", Integer.toString(2));
        stats.put("miss", Integer.toString(1));
        stats.put("cities", c.getCache().keySet().toString());

        assertEquals(stats, c.getStats());
    }

    @Test
    public void addCity_addsCityToCitiesArray(){
        c = new Cache();
        c.addCity("Porto");

        assertTrue(c.getCities().contains("Porto"));
    }

}