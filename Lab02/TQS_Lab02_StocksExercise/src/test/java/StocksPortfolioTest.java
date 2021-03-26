import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class StocksPortfolioTest {


    @Test
    void getTotalValueTest(){

        StockMarket market = mock(StockMarket.class);
        StocksPortfolio port = new StocksPortfolio(market);

        when(market.getPrice("EBAY")).thenReturn(5.0);
        when(market.getPrice("MSFT")).thenReturn(3.0);

        Stock s1 = new Stock("EBAY", 3);
        Stock s2 = new Stock("MSFT", 2);

        port.addStock(s1);
        port.addStock(s2);

        //assertEquals(21, port.getTotalValue(), "O valor total deveria ser 21");
        assertThat(port.getTotalValue(), is(21.0));
        verify(market, times(2)).getPrice(anyString());
    }
}
