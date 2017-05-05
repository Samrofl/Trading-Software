
/**
 *
 * @author sb
 */
public class Stock 
{
    // class variables
    private int stockID;
    private String companyName;
    private float stockPrice;

    /**
     * class constructor
     * @param id ID of the stock
     * @param name Name of the stock
     * @param value The stocks starting value
     */
    public Stock(int id, String name, float value) 
    {
        stockID=id;
        companyName = name;
        stockPrice = value;
    }
    

    /**
     * Set method to assign a stockName
     * @param newName New name for the stock
     */
    public void setStockName(String newName)
    {
        companyName = newName;
    }

    /**
     * This method returns the stock objects current companyName value.
     * @return The current stock name
     */
    public String getStockName()
    {
        return companyName;
    }
    
    /**
     * This method is used to assign a new value to the stock objects stockPrice attribute
     * @param newStockPrice The new value of the stock
     */
    public void updateStockPrice(float newStockPrice)
    {
        stockPrice = newStockPrice;
    }

    /**
     * This method returns the sock objects current stockPrice value
     * @return The current value of the stock
     */
    public float getPrice()
    {
        return stockPrice;
    }
}
