public class Stock {

    private String name;
    private float quantity;

    public Stock(String n, int q){
        this.name = n;
        this.quantity = q;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }
}
