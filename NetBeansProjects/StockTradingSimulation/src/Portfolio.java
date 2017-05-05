import java.util.ArrayList;
import java.util.HashMap;

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
    
    // class constructors  
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

    // class methods
    
    // this method is used to reassign the current name of the portfolio object
    public void setName(String name)
    {
        clientName = name;
    }
    
    // this method is used to get the current name attribute of the portfolio object
    public String getName()
    {
        return clientName;
    }
    
    // this method is used to see what the current amount of cash the client has in their portfolio
    public float getCash()
    {
        return clientCash;
    }
    
    // this method is used to add more cash to the clients portfolio
    public void addCash(float cash)
    {
        clientCash += cash;
    }
    
    // this method is used to take out money from the clients portfolio
    // note if you try to withdraw more cash the client currently has then this method returns 0.
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
    
    // this method returns the total value of all of the ass1ets which the client currently has in their portfolio.
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
    
    // this method returns the total net worth of the client.
    public float getTotalWorth()
    {
        return getAssetValue() + clientCash;
    }
    
    // this method returns the clients current prefered risk level
    public RiskLevel getRiskLevel()
    {
        return clientRisk;
    }
    
    // this method is used to change the clients risk level
    public void setRiskLevel(RiskLevel RiskLevel)
    {
        clientRisk = RiskLevel;
    }
    
    public int getClientID(){
        return clientID;
    }
    
    public int getStockCount(Stock s){
        return clientAssets.get(s);
    }
    
    // this method is used to add stock in the clients portfolio
    // if the stockToAdd parameter already exists in the portfolio then this method increases that stock amount by the 'amount' parameter
    // if the stockToAdd parameter does not exist this method creates a new key value pair consisting of the stockToAdd + amount parameters
    // and inserts them into the clientsAssets hashmap.
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
    
    // this method is used to remove stock from the clients portfolio
    // if the stockToBeSold parameter does not exist in the portfolio this method returns false indicating that this method did not sucessfully complete
    // if the stockToBeSold parameter does exist but the amountToSell exceeds the amount of that stock which the portfolio currently holds, again we return false.
    // if the stockToBeSold parameter does exist and we the amountToSell parameter is within the acceptable range this method returns true 
    public boolean sellStock(Stock stockToBeSold, int amountToSell)
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
                return true;
            }
        }
        return false;
    }
    
    public void buyStock(Stock stockToBeBought, int amountToBuy){
        if (!stockToBuy.containsKey(stockToBeBought)){
                stockToBuy.put(stockToBeBought,amountToBuy);
            } else{
                amountToBuy+=stockToBuy.get(stockToBeBought);
                stockToBuy.put(stockToBeBought,amountToBuy);
            }
    }
    
    // this method searches through each stock in the clients portfolio and if a stock has a price of 0 it removes that stock from the portfolio.
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
    
    //Returns the stock based on integer value to find in the arraylist.
    //Used for selling / buying.
    public Stock getStock(int i){
        return keysAsArray.get(i);
    }
    
    //Returns stockToSell hashmap
    public HashMap<Stock,Integer> getToBeSold(){
        return stockToSell;
    }

    public HashMap<Stock, Integer> getStockToBuy() {
        return stockToBuy;
    }
    
    
    public int getSize(){
        return clientAssets.size();
    }
}

