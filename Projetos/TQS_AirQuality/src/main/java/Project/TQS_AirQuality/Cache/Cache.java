package Project.TQS_AirQuality.Cache;

import Project.TQS_AirQuality.Models.Weather;
import Project.TQS_AirQuality.Models.Response;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Cache {

    private long TIMEOUT = 1000000;

    private static List<String> cities = new ArrayList<>();
    private static Map<String, Response> cityInfo = new HashMap<>();
    private static int misses = 0;
    private static int hits = 0;

    public Cache() {}

    public void setMiss() {
        misses++;
    }

    public void setHit() {
        hits++;
    }

    public void setCityInfo(String city, Response info) {
        cityInfo.put(city.toLowerCase(), info);
    }

    public Response getCityInfo(String city) {
        if(cityInfo.get(city.toLowerCase()).toString().length() > 0){
            hits++;
        }
        else{
            misses++;
        }
        return cityInfo.get(city.toLowerCase());
    }

    public void addCity(String city){
        cities.add(city);
    }

    public List<String> getCities(){
        if(cities.size() > 0){
            hits++;
        }
        else{
            misses++;
        }
        return cities;
    }

    public Map<String, String> getStats(){
        Map<String, String> stats = new HashMap<>();
        stats.put("miss", String.valueOf(misses));
        stats.put("hit", String.valueOf(hits));
        stats.put("cities", cityInfo.keySet().toString());
        hits++;
        return stats;
    }

    public Map<String, Response> getCache() {
        return cityInfo;
    }

    public boolean exists(String city) {
        long timeNow = new Timestamp(System.currentTimeMillis()).getTime();
        return (cityInfo.containsKey(city) && cityInfo.get(city) != null && timeNow - cityInfo.get(city).getTimestamp() < TIMEOUT);
    }
}
