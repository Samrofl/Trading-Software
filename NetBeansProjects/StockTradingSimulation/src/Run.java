
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sb
 */
public class Run {
    public static TradingExchange exchange;
    public static StockMarket market;
    public static ArrayList<Portfolio> portfolios = new ArrayList();
    public static ArrayList<Company> companies = new ArrayList();
    public static ArrayList<RandomTrader> randomTraders = new ArrayList();
    private static final int data[][]={
        {1505,0,1456,0,8464,4336,6424,6479,0,4827,0,4551,0,7774,109,4656,5344,5576,3181,9496},
        {1672,0,4816,0,701,9571,498,6345,0,0,0,2538,0,9872,0,3907,0,7793,0,5022},
        {9746,8107,0,0,8917,0,8152,8437,0,0,6957,5059,0,6348,3987,0,7542,9015,0,0},
        {330,1893,0,0,7714,0,8526,1385,1319,0,0,636,0,842,9042,0,0,4514,6619,0},
        {4077,0,0,0,4707,0,0,4272,8119,0,0,4535,0,5757,9088,0,0,1307,0,0},
        {8054,0,0,0,3238,8593,0,9841,0,3073,8438,5244,0,1828,337,0,5857,7529,0,0},
        {7841,0,6380,0,3701,0,0,2774,0,1354,0,9874,9837,0,452,8371,4400,4553,0,0},
        {6187,0,0,0,3276,0,0,1833,8644,180,1563,5309,4283,0,5229,7946,8235,2337,0,0},
        {2304,0,0,0,2447,1611,0,4188,1206,6464,0,6772,6332,9579,8315,4216,8622,6728,0,8969},
        {8284,0,7348,6000,5735,8789,0,9446,0,7102,1042,5482,4548,0,5441,7604,0,7648,0,7513}};
        
    
    
    public Run(){
        exchange = new TradingExchange();
        market = new StockMarket();
    }
    
    public static void main(String[] args) {
        Run run = new Run();
        //Initialise portfolios
        portfolios.add(new Portfolio("Norbert DaVinci", 100000, RiskLevel.MEDIUM));
        portfolios.add(new Portfolio("Ellen Fotheringay-Smythe", 100000, RiskLevel.MEDIUM));
        portfolios.add(new Portfolio("Donald Shrek", 100000, RiskLevel.MEDIUM));
        portfolios.add(new Portfolio("Sir Melvin Codd", 100000, RiskLevel.MEDIUM));
        portfolios.add(new Portfolio("A&G Investments", 100000, RiskLevel.MEDIUM));
        portfolios.add(new Portfolio("Trinity Investments", 50000, RiskLevel.MEDIUM));
        portfolios.add(new Portfolio("Ivor Lott", 50000, RiskLevel.MEDIUM));
        portfolios.add(new Portfolio("Justine Thyme", 50000, RiskLevel.MEDIUM));
        portfolios.add(new Portfolio("Saeed Pune", 50000, RiskLevel.MEDIUM));
        portfolios.add(new Portfolio("Xi Xian", 50000, RiskLevel.MEDIUM));
        
        //Initialise companies.
        companies.add(new Company("Pear Computing", CompanyType.HITECH, RiskLevel.HIGH, 50000, 650));
        companies.add(new Company("Wong Holdings", CompanyType.PROPERTY, RiskLevel.HIGH, 10000, 126));
        companies.add(new Company("Williams Leisure", CompanyType.HARD, RiskLevel.LOW, 20000, 82));
        companies.add(new Company("The Lovely Pie Co", CompanyType.FOOD, RiskLevel.LOW, 6000, 24));
        companies.add(new Company("Q1Q Tech", CompanyType.HITECH, RiskLevel.HIGH, 48900, 130));
        companies.add(new Company("Texas Crisps", CompanyType.FOOD, RiskLevel.LOW, 32900, 180));
        companies.add(new Company("Swann Holdings", CompanyType.PROPERTY, RiskLevel.HIGH, 23600, 45));
        companies.add(new Company("Patels Sauces", CompanyType.FOOD, RiskLevel.LOW, 55000, 100));
        companies.add(new Company("Gardens 'R' Us", CompanyType.HARD, RiskLevel.LOW, 19288, 19));
        companies.add(new Company("Sussex Flats", CompanyType.PROPERTY, RiskLevel.HIGH, 23000, 570));
        companies.add(new Company("Dawn Technology", CompanyType.HITECH, RiskLevel.HIGH, 18000, 12));
        companies.add(new Company("Excelsior Foods", CompanyType.FOOD, RiskLevel.LOW, 50000, 540));
        companies.add(new Company("Supreme Sk8", CompanyType.HARD, RiskLevel.LOW, 25000, 345));
        companies.add(new Company("Luxury Caravans", CompanyType.PROPERTY, RiskLevel.HIGH, 42000, 268));
        companies.add(new Company("WyreCraft", CompanyType.HITECH, RiskLevel.HIGH, 42000, 637));
        companies.add(new Company("Upduff and Co", CompanyType.FOOD, RiskLevel.LOW, 36700, 340));
        companies.add(new Company("Downe and Co", CompanyType.HARD, RiskLevel.LOW, 40000, 99));
        companies.add(new Company("Skinners", CompanyType.PROPERTY, RiskLevel.HIGH, 57000, 368));
        companies.add(new Company("Wazoolt", CompanyType.HITECH, RiskLevel.HIGH, 9800, 45));
        companies.add(new Company("Whizzer and Chipps", CompanyType.FOOD, RiskLevel.LOW, 31000, 210));
        
        //Initialise portfolios.
        for (int i=0;i<portfolios.size();i++){
            for(int j=0;j<20;j++){
                portfolios.get(i).addStock(companies.get(j).getStock(),data[i][j]);
            }
        }
        for (int i=0;i<portfolios.size();i++){
            System.out.println(portfolios.get(i).getTotalWorth());
        }
        
        //Create traders 
        randomTraders.add(new RandomTrader(TraderType.SELLER));
        randomTraders.add(new RandomTrader(TraderType.SELLER));
        randomTraders.add(new RandomTrader(TraderType.BALANCED));
        randomTraders.add(new RandomTrader(TraderType.PURCHASER));
        
       
        //Distribute portfolios between random traders
        //Needs to be rewritten with a loop but I am too tired to do it now.
        randomTraders.get(0).addClient(portfolios.get(0));
        randomTraders.get(0).addClient(portfolios.get(1));
        randomTraders.get(0).addClient(portfolios.get(2));
        randomTraders.get(1).addClient(portfolios.get(3));
        randomTraders.get(1).addClient(portfolios.get(4));
        randomTraders.get(1).addClient(portfolios.get(5));
        randomTraders.get(2).addClient(portfolios.get(6));
        randomTraders.get(2).addClient(portfolios.get(7));
        randomTraders.get(3).addClient(portfolios.get(8));
        randomTraders.get(3).addClient(portfolios.get(9));
        
        //Print share index to test it
        System.out.println(exchange.getShareIndex(companies));
        
        System.out.println(randomTraders.get(0).getTotalAssets() + "\n ----");
        
        //Perform initial transaction
        for(int i=0;i<randomTraders.size();i++){
            randomTraders.get(i).sell();
        }
        
        for(int i=0;i<randomTraders.size();i++){
            randomTraders.get(i).buy();
        }
        
        //Add elements to for sale hashmap
        for(int i=0;i<randomTraders.size();i++){
            for(int j=0;j<randomTraders.get(i).getPortfolioSize();j++){
                exchange.addForSale(randomTraders.get(i).getClient(j).getToBeSold());
            }
        }
        
        //Add elements to for purchase hashmap
        for(int i=0;i<randomTraders.size();i++){
            for(int j=0;j<randomTraders.get(i).getPortfolioSize();j++){
                exchange.addToBuy(randomTraders.get(i).getClient(j).getStockToBuy());
            }
        }
        
        //Print the hashmap to test it.
        System.out.println("FOR SALE");
        exchange.printForSale();
        System.out.println("\nTO BUY");
        exchange.printToBuy();
        
        
        //This runs the market for the year.
        while (market.getMonth()!=13){
            market.incrementTime();
            //System.out.println(market.isHoliday() + "-" + market.getWeekdayName(market.getWeekdays(), market.getWeekday()) + " " + market.getDay() + "-" + market.getMonth() + " " + String.format("%02d",market.getHour()) + ":" + String.format("%02d", market.getMinute()));
        }
    }
}
