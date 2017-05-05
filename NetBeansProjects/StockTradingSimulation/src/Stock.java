
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
     * @param id
     * @param name
     * @param value
     */
    public Stock(int id, String name, float value) 
    {
        stockID=id;
        companyName = name;
        stockPrice = value;
    }
    

    /**
     * Set method to assign a stockName
     * @param newName
     */
    public void setStockName(String newName)
    {
        companyName = newName;
    }

    /**
     * This method returns the stock objects current companyName value.
     * @return
     */
    public String getStockName()
    {
        return companyName;
    }
    
    /**
     * This method is used to assign a new value to the stock objects stockPrice attribute
     * @param newStockPrice
     */
    public void updateStockPrice(float newStockPrice)
    {
        stockPrice = newStockPrice;
    }

    /**
     * This method returns the sock objects current stockPrice value
     * @return
     */
    public float getPrice()
    {
        return stockPrice;
    }
}
