public class Company 
{
    // class variables
    private String companyName;
    private CompanyType companyType;
    private RiskLevel companyRisk;
    private int stockCount;
    private boolean isInsolvent;
    private Stock stock;
    private static int counter=0;
    private int companyID;

    // class constructor
    public Company(String name, CompanyType type, RiskLevel risk, int totalShares, float sharePrice) 
    {
        counter++;
        companyID=counter;
        companyName = name;
        companyType = type;
        companyRisk = risk;
        stockCount = totalShares;
        float stockValue = (sharePrice/100);
        isInsolvent = false;
        stock = new Stock(companyID, name, stockValue);
    }
    
    // class methods
    
    // this method is used to assign a new name to the companyName attribute 
    public void setName(String newName)
    {
        companyName = newName;
    }
    
    // this method returns the current CompanyName value
    public String getName()
    {
        return companyName;
    }
    
    // this method is used to assign a new type to the companyType attribute
    public void setType(CompanyType type)
    {
        companyType = type;
    }
    
    // this method returns the current CompanyType value
    public CompanyType getType()
    {
        return companyType;
    }
    
    // this method is used to assign a risk level to the CompanyRisk attribute
    public void setRisk(RiskLevel risk)
    {
        companyRisk = risk;
    }
    
    // this method returns the current companyRisk value.
    public RiskLevel getRisk()
    {
        return companyRisk;
    }
    
    // i am not sure how this is to be implemented so i have left it blank...
    public void issueStock()
    {
        
    }
    
    // this method is used to make a company object insolvent.
    public void setInsolvent()
    {
        isInsolvent = true;
    }
    
    // this method is used to check if a company object is insolvent.
    public boolean isCompanyInsolvent()
    {
        return isInsolvent;
    }

    public int getCompanyID() {
        return companyID;
    }
    
    public Stock getStock(){
        return stock;
    }
    
    public float getSharePrice(){
        return getStock().getPrice();
    }
}
