/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sb
 */



public class TradingExchange {
    
    private float shareIndex;
    private HashMap<Stock,Integer> forSale;
    private HashMap<Stock,Integer> toBuy;
    private HashMap<Stock,Integer> supplyDemand;
    
    /**
     *
     */
    public TradingExchange(){
        forSale = new HashMap();
        toBuy = new HashMap();
        supplyDemand = new HashMap();
    }
    
    /**
     * Big trade method to be called each iteration of the program.
     * This method is incomplete, it cannot handle any instances where a portfolio cannot sell / buy everything it wants to.
     * @param clients
     */
    public void trade(ArrayList<Portfolio> clients){
        for(Portfolio p : clients){ 
            for(Map.Entry<Stock,Integer> entry : p.getToBeSold().entrySet()){//Deal with sales
                if(supplyDemand.get(entry.getKey())>0){ //If the seller can sell everything, just add the cash to their portfolio.
                    p.addCash(entry.getKey().getPrice()*entry.getValue());
                }
            }
            
            for(Map.Entry<Stock,Integer> entry : p.getStockToBuy().entrySet()){ // Deal with purchasing
                if(supplyDemand.get(entry.getKey())<0){ //If the buyer can buy everything, just add the stocks to their portfolio and remove the cash
                    p.withdrawCash(entry.getKey().getPrice()*entry.getValue());
                    p.addStock(entry.getKey(),entry.getValue());
                }
            } 
        }
    }
    

    /**
     * Get method to return the share index
     * @param companies
     * @return
     */
    public float getShareIndex(ArrayList<Company> companies) {
        for(Company company: companies){
            shareIndex += company.getStock().getPrice();
        }
        shareIndex = (shareIndex/companies.size());
        return shareIndex;
    }
    
    /**
     * Method to add stocks to the forSale hashmap
     * @param toSell
     */
    public void addForSale(HashMap<Stock,Integer> toSell){
        
        for(Map.Entry<Stock,Integer> entry : toSell.entrySet()) {
            Stock stock = entry.getKey();
            int amount = entry.getValue();
            
            if(forSale.containsKey(stock)){
                int currentAmount = forSale.get(stock);
                amount = amount+currentAmount;
                forSale.put(stock, amount);
            }
            else{
                forSale.put(stock,amount);
            }
        }
    }
    
    /**
     * Method to add stocks to the toBuy hashmap
     * @param forPurchase
     */
    public void addToBuy(HashMap<Stock,Integer> forPurchase){
        for(Map.Entry<Stock,Integer> entry : forPurchase.entrySet()) {
            Stock stock = entry.getKey();
            int amount = entry.getValue();
            
            if(toBuy.containsKey(stock)){
                int currentAmount = toBuy.get(stock);
                amount = amount+currentAmount;
                toBuy.put(stock, amount);
            }
            else{
                toBuy.put(stock,amount);
            }
        }
    }

    /**
     * Get method to return the forSale hashmap
     * @return
     */
    public HashMap<Stock, Integer> getForSale() {
        return forSale;
    }
    
    /**
     * Method to calculate the total supply and demand
     * @param companyList
     */
    public void calculateSupplyDemand(ArrayList<Company> companyList){
        
        for(Stock stock1: toBuy.keySet()){
            for (Stock stock2: forSale.keySet()){
                if (stock1 == stock2){
                    int difference = toBuy.get(stock1) - forSale.get(stock2);
                    supplyDemand.put(stock1,difference);
                }
            }
        }
        
        for(Company c: companyList){
            if (toBuy.containsKey(c.getStock()) && !forSale.containsKey(c.getStock())){
                if(supplyDemand.containsKey(c.getStock())){
                    int demand = toBuy.get(c.getStock()) +supplyDemand.get(c.getStock());
                    supplyDemand.put(c.getStock(),demand);
                }
                else {
                    supplyDemand.put(c.getStock(),toBuy.get(c.getStock()));
                }
            }
            if (!toBuy.containsKey(c.getStock()) && forSale.containsKey(c.getStock())){
                if(supplyDemand.containsKey(c.getStock())){
                    int supply = supplyDemand.get(c.getStock()) - (forSale.get(c.getStock()));
                    supplyDemand.put(c.getStock(),supply);
                }
                else {
                    supplyDemand.put(c.getStock(),-(forSale.get(c.getStock())));
                }
            }
        }
        printSupplyDemand();        
    }

    /**
     * Print method for testing 
     */
    public void printForSale(){
        for(Stock s : forSale.keySet()){
            String key = s.getStockName();
            String value = forSale.get(s).toString();
            System.out.println(key + " : " + value);
        }
    }
    
    /**
     * Print method for testing
     */
    public void printToBuy(){
        for(Stock s : toBuy.keySet()){
            String key = s.getStockName();
            String value = toBuy.get(s).toString();
            System.out.println(key + " : " + value);
        }
    }
    
    /**
     * Print method for testing
     */
    public void printSupplyDemand(){
        for(Stock s : supplyDemand.keySet()){
            String key = s.getStockName();
            String value = supplyDemand.get(s).toString();
            System.out.println(key + " : " + value);
        }
    }

}
    
    
    

