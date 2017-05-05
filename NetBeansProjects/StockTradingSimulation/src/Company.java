
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
     * @param name Name of the company
     * @param type The type of company
     * @param risk The risk associated with the company
     * @param totalShares The total shares the company has to offer
     * @param sharePrice The current share value of the company
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
     * @param newName The new company name
     */
    public void setName(String newName)
    {
        companyName = newName;
    }
    

    /** 
     * This method returns the current CompanyName value
     * @return The current company name
     */
    public String getName()
    {
        return companyName;
    }
    

    /**
     * this method is used to assign a new type to the companyType attribute
     * @param type The type of the company
     */
    public void setType(CompanyType type)
    {
        companyType = type;
    }
    

    /**
     * this method returns the current CompanyType value
     * @return The current type of the company
     */
    public CompanyType getType()
    {
        return companyType;
    }
    

    /**
     * This method is used to assign a risk level to the CompanyRisk attribute
     * @param risk The new risk level of the company
     */
    public void setRisk(RiskLevel risk)
    {
        companyRisk = risk;
    }
    

    /**
     * this method returns the current companyRisk value.
     * @return The risk level of the company
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
     * @return Whether the company is insolvent
     */
    public boolean isCompanyInsolvent()
    {
        return isInsolvent;
    }

    /**
     * Get method to return a companyID
     * @return The Company's ID
     */
    public int getCompanyID() {
        return companyID;
    }
    
    /**
     * return method to return the company's stock object
     * @return The company's stock object
     */
    public Stock getStock(){
        return stock;
    }
}
