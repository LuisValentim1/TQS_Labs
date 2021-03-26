import java.util.ArrayList;

public class StocksPortfolio {

    private String name;
    private ArrayList<Stock> stockL = new ArrayList<Stock>();
    private StockMarket stockM;

    public StocksPortfolio(StockMarket market){
        this.stockM = market;
    }

    public double getTotalValue(){
        double total = 0;
        for (int i = 0; i<this.stockL.size(); i++){
            Stock cur = this.stockL.get(i);
            float stockNum = cur.getQuantity();
            double price = this.stockM.getPrice(cur.getName());
            total += price * stockNum;
        }
        return total;
    }

    public void addStock(Stock x){
        stockL.add(x);
    }

    public StockMarket getStockM() {
        return stockM;
    }

    public void setStockM(StockMarket stockM) {
        this.stockM = stockM;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
