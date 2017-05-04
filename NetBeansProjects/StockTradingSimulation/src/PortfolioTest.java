

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PortfolioTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PortfolioTest
{
    /**
     * Default constructor for test class PortfolioTest
     */
    public PortfolioTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    @Test
    public void TestPortfolio()
    {
        Portfolio portfolio1 = new Portfolio("new", 10000, "LOW");
        assertEquals("new", portfolio1.getName());
        assertEquals(10000, portfolio1.getCash(), 0.1);
        assertEquals("LOW", portfolio1.getRiskLevel());
    }
}
