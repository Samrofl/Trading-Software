package test;

public class Stock 
{
    // class variables
    private String companyName;
    private float stockPrice;

    // class constructor
    public Stock(String name, float value) 
    {
        companyName = name;
        stockPrice = value;
    }
    
    // class methods
    
    // this method is used to assign a new name to the current companyName attribute
    public void setStockName(String newName)
    {
        companyName = newName;
    }
    
    // this method returns the stock objects current companyName value.
    public String getStockName()
    {
        return companyName;
    }
    
    // this method is used to assign a new value to the stock objects stockPrice attribute
    public void updateStockPrice(float newStockPrice)
    {
        stockPrice = newStockPrice;
    }
    
    // this method returns the sock objects current stockPrice value
    public float getStockPrice()
    {
        return stockPrice;
    }
}
