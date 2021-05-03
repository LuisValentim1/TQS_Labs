package Project.TQS_AirQuality.Models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "data",
        "city_name",
        "lon",
        "timezone",
        "lat",
        "country_code",
        "state_code"
})

public class Response {

    @JsonProperty("data")
    private Weather[] data = null;
    @JsonProperty("city_name")
    private String city_name;
    @JsonProperty("lon")
    private String lon;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("lat")
    private String lat;
    @JsonProperty("country_code")
    private String country_code;
    @JsonProperty("state_code")
    private String state_code;


    @JsonProperty("data")
    public Weather[] getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Weather[] data) {
        this.data = data;
    }

    @JsonProperty("city_name")
    public String getCity_name() {
        return city_name;
    }

    @JsonProperty("city_name")
    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    @JsonProperty("lon")
    public String getLon() {
        return lon;
    }

    @JsonProperty("lon")
    public void setLon(String lon) {
        this.lon = lon;
    }

    @JsonProperty("timezone")
    public String getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @JsonProperty("lat")
    public String getLat() {
        return lat;
    }

    @JsonProperty("lat")
    public void setLat(String lat) {
        this.lat = lat;
    }

    @JsonProperty("country_code")
    public String getCountry_code() {
        return country_code;
    }

    @JsonProperty("country_code")
    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    @JsonProperty("state_code")
    public String getState_code() {
        return state_code;
    }

    @JsonProperty("state_code")
    public void setState_code(String state_code) {
        this.state_code = state_code;
    }
}
