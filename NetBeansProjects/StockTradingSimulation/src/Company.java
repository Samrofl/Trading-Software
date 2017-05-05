
/**
 *
 * @author sb
 */
public class Company 
{
    // class variables
    private String companyName;
    private CompanyType companyType;
    private RiskLevel companyRisk;
    private int stockCount;
    private float stockValue;
    private boolean isInsolvent;
    private Stock stock;
    private static int counter=0;
    private int companyID;


    /**
     * class constructor
     * @param name
     * @param type
     * @param risk
     * @param totalShares
     * @param sharePrice
     */
    public Company(String name, CompanyType type, RiskLevel risk, int totalShares, float sharePrice) 
    {
        counter++;
        companyID=counter;
        companyName = name;
        companyType = type;
        companyRisk = risk;
        stockCount = totalShares;
        stockValue = (sharePrice/100);
        isInsolvent = false;
        stock = new Stock(companyID, name, stockValue);
    }
    

    /**
     * This method is used to assign a new name to the companyName attribute 
     * @param newName
     */
    public void setName(String newName)
    {
        companyName = newName;
    }
    

    /** 
     * This method returns the current CompanyName value
     * @return
     */
    public String getName()
    {
        return companyName;
    }
    

    /**
     * this method is used to assign a new type to the companyType attribute
     * @param type
     */
    public void setType(CompanyType type)
    {
        companyType = type;
    }
    

    /**
     * this method returns the current CompanyType value
     * @return
     */
    public CompanyType getType()
    {
        return companyType;
    }
    

    /**
     * This method is used to assign a risk level to the CompanyRisk attribute
     * @param risk
     */
    public void setRisk(RiskLevel risk)
    {
        companyRisk = risk;
    }
    

    /**
     * this method returns the current companyRisk value.
     * @return
     */
    public RiskLevel getRisk()
    {
        return companyRisk;
    }
    

    /**
     * Unused issueStock method from the class diagram
     */
    public void issueStock()
    {
        
    }
    

    /**
     * this method is used to make a company object insolvent.
     */
    public void setInsolvent()
    {
        isInsolvent = true;
    }
    

    /**
     * this method is used to check if a company object is insolvent.
     * @return
     */
    public boolean isCompanyInsolvent()
    {
        return isInsolvent;
    }

    /**
     * Get method to return a companyID
     * @return
     */
    public int getCompanyID() {
        return companyID;
    }
    
    /**
     * return method to return the company's stock object
     * @return
     */
    public Stock getStock(){
        return stock;
    }
}
