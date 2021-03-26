import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.net.URISyntaxException;


class AddressResolverTest {

    JSONObject jsonReturn;

    @Test
    void  findAddressForLocationTest() throws IOException, URISyntaxException, ParseException {
        TqsBasicHttpClient client = new TqsBasicHttpClient();
        AddressResolver resolver = new AddressResolver(client);
        Address ad = resolver.findAddressForLocation(30.333472,-81.470448);
        Address expected = new Address("Ashley Melisse Boulevard", "Jacksonville", "FL", "32225", null);
        assertEquals(expected, ad);
    }

}