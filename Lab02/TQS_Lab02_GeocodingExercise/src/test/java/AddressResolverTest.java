import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddressResolverTest {

    JSONObject jsonReturn;

    @Test
    void  findAddressForLocationTest() throws IOException, URISyntaxException, ParseException {
        ISimpleHttpClient client = (ISimpleHttpClient) Mockito.mock(ISimpleHttpClient.class);
        AddressResolver resolver = new AddressResolver(client);
        String json = "{\"info\":{\"statuscode\":0,\"copyright\":{\"text\":\"\\u00A9 2021 MapQuest, Inc.\",\"imageUrl\":\"http://api.mqcdn.com/res/mqlogo.gif\",\"imageAltText\":\"\\u00A9 2021 MapQuest, Inc.\"},\"messages\":[]},\"options\":{\"maxResults\":1,\"thumbMaps\":true,\"ignoreLatLngInput\":false},\"results\":[{\"providedLocation\":{\"latLng\":{\"lat\":30.333472,\"lng\":-81.470448}},\"locations\":[{\"street\":\"Ashley Melisse Boulevard\",\"adminArea6\":\"\",\"adminArea6Type\":\"Neighborhood\",\"adminArea5\":\"Jacksonville\",\"adminArea5Type\":\"City\",\"adminArea4\":\"\",\"adminArea4Type\":\"County\",\"adminArea3\":\"FL\",\"adminArea3Type\":\"State\",\"adminArea1\":\"US\",\"adminArea1Type\":\"Country\",\"postalCode\":\"32225\",\"geocodeQualityCode\":\"B1AAA\",\"geocodeQuality\":\"STREET\",\"dragPoint\":false,\"sideOfStreet\":\"N\",\"linkId\":\"0\",\"unknownInput\":\"\",\"type\":\"s\",\"latLng\":{\"lat\":30.333486,\"lng\":-81.470445},\"displayLatLng\":{\"lat\":30.333486,\"lng\":-81.470445},\"mapUrl\":\"http://open.mapquestapi.com/staticmap/v5/map?key=uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ&type=map&size=225,160&locations=30.33348557609115,-81.47044502597335|marker-sm-50318A-1&scalebar=true&zoom=15&rand=-2086278253\",\"roadMetadata\":null}]}]}";
        Mockito.when(client.get("http://open.mapquestapi.com/geocoding/v1/reverse?key=uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ&location=30.333472%2C-81.470448&includeRoadMetadata=true")).thenReturn(json);
        Address ad = resolver.findAddressForLocation(30.333472,-81.470448);
        Address expected = new Address("Ashley Melisse Boulevard", "Jacksonville", "FL", "32225", null);
        assertEquals(expected, ad);
        //MatcherAssert.assertThat(ad, Matchers.is(expected));
        }

}