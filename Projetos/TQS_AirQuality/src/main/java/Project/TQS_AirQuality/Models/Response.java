package Project.TQS_AirQuality.Models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.sql.Timestamp;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "data",
})

public class Response {

    private long timestamp;

    @JsonProperty("data")
    private Weather[] data = null;

    public long getTimestamp(){
        return timestamp;
    }

    public void setTimestamp(long timestamp){
        this.timestamp = timestamp;
    }

    @JsonProperty("data")
    public Weather[] getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Weather[] data) {
        this.data = data;
    }


}
