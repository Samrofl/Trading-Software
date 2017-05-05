import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author sb
 */
public class Portfolio 
{
    // class variables
    private static int counter=0;
    private int clientID;
    private String clientName;
    private float clientCash;
    private final HashMap<Stock,Integer> clientAssets;
    private HashMap<Stock,Integer> stockToSell;
    private HashMap<Stock,Integer> stockToBuy;
    ArrayList<Stock> keysAsArray;
    private RiskLevel clientRisk; 

    /**
     * class constructors  
     * @param name Name of the company
     * @param cash Company's starting cash
     * @param risk Company's risk level
     */
    public Portfolio(String name, float cash, RiskLevel risk) 
    {
        counter++;
        clientID=counter;
        clientName = name;
        clientCash = cash;
        clientRisk = risk;
        clientAssets = new HashMap<>();
        stockToSell = new HashMap<>();
        stockToBuy = new HashMap<>();
    }
    

    /**
     * this method is used to reassign the current name of the portfolio object
     * @param name New name of the client
     */
    public void setName(String name)
    {
        clientName = name;
    }

    /**
     *this method is used to get the current name attribute of the portfolio object
     * @return Clients name
     */
    public String getName()
    {
        return clientName;
    }
    

    /**
     *This method is used to see what the current amount of cash the client has in their portfolio
     * @return Clients cash
     */
    public float getCash()
    {
        return clientCash;
    }
    /**
     * This method is used to add more cash to the clients portfolio
     * @param cash Cash to be added to the client
     */
    public void addCash(float cash)
    {
        clientCash += cash;
    }

    /**
     * This method is used to take out money from the clients portfolio
     * @param amountToWithDraw Cash to be taken away from the client
     */
    public void withdrawCash(float amountToWithDraw)
    {
        if ((clientCash - amountToWithDraw) >= 0)
        {
            clientCash = clientCash - amountToWithDraw;
        }
        else
        {
            System.out.println("WITHDRAW TOO MUCH");
        }   
    }
    

    /**
     * this method returns the total value of all of the ass1ets which the client currently has in their portfolio.
     * @return Total value of the clients assets
     */
    public float getAssetValue()
    {
        float total = 0;
        int i=1;
        for(Stock s : clientAssets.keySet()) 
        {
            float stockWorth = s.getPrice() * clientAssets.get(s);
            total += stockWorth;
        }
        return total;
    }
    
    /**
     * this method returns the total net worth of the client.
     * @return Total worth of the cleient
     */
    public float getTotalWorth()
    {
        return getAssetValue() + clientCash;
    }
    

    /**
     * this method returns the clients current prefered risk level
     * @return Clients risk level
     */
    public RiskLevel getRiskLevel()
    {
        return clientRisk;
    }
    

    /**
     * this method is used to change the clients risk level
     * @param RiskLevel Clients new risk level
     */
    public void setRiskLevel(RiskLevel RiskLevel)
    {
        clientRisk = RiskLevel;
    }
    
    /**
     * Getter for client id
     * @return Clients ID
     */
    public int getClientID(){
        return clientID;
    }
    
    /**
     * Returns specified stock object's count
     * @param s Stock to be found
     * @return Stock count
     */
    public int getStockCount(Stock s){
        return clientAssets.get(s);
    }
    

    /**
     * this method is used to add stock in the clients portfolio
     * if the stockToAdd parameter already exists in the portfolio then this method increases that stock amount by the 'amount' parameter
     * if the stockToAdd parameter does not exist this method creates a new key value pair consisting of the stockToAdd + amount parameters
     * and inserts them into the clientsAssets hashmap.
     * @param stockToAdd Stock to be added
     * @param amount Amount of stock to be added
     */
    public void addStock(Stock stockToAdd, int amount)
    {
        if (clientAssets.containsKey(stockToAdd)) 
        {
            int currentStockAmount = clientAssets.get(stockToAdd);
            clientAssets.put(stockToAdd, (currentStockAmount + amount));
        }
        else
        {
            clientAssets.put(stockToAdd, amount);
        }
        keysAsArray = new ArrayList<>(clientAssets.keySet());
    }

    /**
     *  this method is used to remove stock from the clients portfolio
     * if the stockToBeSold parameter does not exist in the portfolio this method returns false indicating that this method did not sucessfully complete
     * if the stockToBeSold parameter does exist but the amountToSell exceeds the amount of that stock which the portfolio currently holds, again we return false.
     * if the stockToBeSold parameter does exist and we the amountToSell parameter is within the acceptable range this method returns true 
     * @param stockToBeSold Stock to be sold
     * @param amountToSell Amount of stock to be sold
     */
    public void sellStock(Stock stockToBeSold, int amountToSell)
    {
        if (clientAssets.containsKey(stockToBeSold))
        {
            int currentStockQuantity = clientAssets.get(stockToBeSold);
            if (currentStockQuantity - amountToSell >= 0) 
            {
                int newStockQuantity = currentStockQuantity - amountToSell;
                if (!stockToSell.containsKey(stockToBeSold)){
                    //Test
                    stockToSell.put(stockToBeSold,amountToSell);
                } else{
                    amountToSell+=stockToSell.get(stockToBeSold);
                    stockToSell.put(stockToBeSold,amountToSell);
                }
                clientAssets.put(stockToBeSold, newStockQuantity);
            }
        }
    }
    
    /**
     * This method buys a specific amount of stock and adds it to the toBeBought hashmap
     * @param stockToBeBought Stock to be purchased
     * @param amountToBuy Amount of stock to be purchased
     */
    public void buyStock(Stock stockToBeBought, int amountToBuy){
        if (!stockToBuy.containsKey(stockToBeBought)){
                stockToBuy.put(stockToBeBought,amountToBuy);
            } else{
                amountToBuy+=stockToBuy.get(stockToBeBought);
                stockToBuy.put(stockToBeBought,amountToBuy);
            }
    }

    /**
     * this method searches through each stock in the clients portfolio and if a stock has a price of 0 it removes that stock from the portfolio.
     */
    public void removeInsolventStock()
    {
        for (Stock s : clientAssets.keySet()) 
        {
            if (s.getPrice() == 0) 
            {
                clientAssets.remove(s);
            }
        }
        keysAsArray = new ArrayList<>(clientAssets.keySet());
    }

    /**
     * Returns the stock based on integer value to find in the arraylist.
     * Used for selling / buying.
     * @param i Integer value to find the stock
     * @return Stock found by integer value
     */
    public Stock getStock(int i){
        return keysAsArray.get(i);
    }
    

    /**
     * Returns stockToSell hashmap
     * @return Stock to sell hashmap
     */
    public HashMap<Stock,Integer> getToBeSold(){
        return stockToSell;
    }

    /**
     * Returns stockToBuy hashmap
     * @return Stock to buy hashmap
     */
    public HashMap<Stock, Integer> getStockToBuy() {
        return stockToBuy;
    }
    
    /**
     * Returns the number of unique stocks a client has
     * @return Size of clients portfolio
     */
    public int getSize(){
        return clientAssets.size();
    }
}

