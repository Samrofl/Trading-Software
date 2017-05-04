

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CompanyTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CompanyTest
{
    /**
     * Default constructor for test class CompanyTest
     */
    public CompanyTest()
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
        Company company1 = new Company("new", "FOOD", "LOW", 10000, 10);
        assertEquals("new", company1.getName());
        assertEquals("FOOD", company1.getType());
        assertEquals("LOW", company1.getRisk());
    }
}
