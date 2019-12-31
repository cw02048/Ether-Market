package android.wallet.com.wallet;

public class ListData {
    private String name;
    private String address;
    private String price;
    private String stock;

    public ListData(String name, String address, String price, String stock){
        this.name = name;
        this.address = address;
        this.price = price;
        this.stock = stock;
    }

    public String getName()
    {
        return this.name;
    }

    public String getAddress()
    {
        return this.address;
    }

    public String getPrice()
    {
        return this.price;
    }

    public String  getStock()
    {
        return this.stock;
    }
}
