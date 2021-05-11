package Project.TQS_AirQuality.Cache;

import Project.TQS_AirQuality.Models.Response;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Cache {

    private static final long TIMEOUT = 200000;

    private List<String> cities;
    private Map<String, Response> cityInfo;
    private int misses;
    private int hits;

    public Cache() {
        this.cities = new ArrayList<>();
        this.cityInfo = new HashMap<>();
        this.hits = 0;
        this.misses = 0;
    }

    public void setMiss() {
        misses++;
    }

    public void setHit() {
        hits++;
    }

    public void setCityInfo(String city, Response info) {
        cityInfo.put(city, info);
    }

    public Response getCityInfo(String city) {
        if(cityInfo.containsKey(city)){
            hits++;
        }
        else{
            misses++;
        }
        return cityInfo.get(city);
    }

    public void addCity(String city){
        cities.add(city);
    }

    public List<String> getCities(){
        if(!cities.isEmpty()){
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
