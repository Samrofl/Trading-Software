
import java.util.ArrayList;

/**
 *
 * @author sb
 */
public abstract class Trader 
{
    // class variables
    private ArrayList<Portfolio> clients;
    
    //class methods

    /**
     * Abstract method to get the client.
     * @param i Integer to find the client
     * @return Client object
     */
    
    public abstract Portfolio getClient(int i);
    
    /**
     * Abstract method to add a client to the trader
     * @param client CLient to be added
     */
    public abstract void addClient(Portfolio client);
    
    /**
     * Abstract method to remove a client from the trader
     * @param id ID of client to be removed
     */
    public abstract void removeClient(int id);
    
    /**
     * Abstract method to buy stock
     */
    public abstract void buy();
    
    /**
     * Abstract method to sell stock
     */
    public abstract void sell();
    
    
    /**
     * Abstract method to get the total assets of the trader
     * @return Returns the total assets of the stock
     */
    public abstract float getTotalAssets();
}
