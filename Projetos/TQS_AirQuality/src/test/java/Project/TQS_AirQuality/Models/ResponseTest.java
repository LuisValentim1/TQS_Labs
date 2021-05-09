package Project.TQS_AirQuality.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class ResponseTest {

    private Response r;
    private Weather[] data;
    private long timeNow;
    private Weather weather;

    @BeforeEach
    public void setup(){
        r = new Response();
    }

    @Test
    public void setData_getData(){
        weather = new Weather();
        data = new Weather[1];
        data[0] = weather;
        r.setData(data);
        assertEquals(data, r.getData());
    }

    @Test
    public void setTimestamp_getTimestamp(){
        timeNow = new Timestamp(System.currentTimeMillis()).getTime();
        r.setTimestamp(timeNow);
        assertEquals(timeNow, r.getTimestamp());
    }

}