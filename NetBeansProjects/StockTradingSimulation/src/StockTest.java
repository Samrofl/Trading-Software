

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class StockTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StockTest
{
    /**
     * Default constructor for test class StockTest
     */
    public StockTest()
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

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void Teststock()
    {
        Stock stock1 = new Stock("new", 10000);
        assertEquals("new", stock1.getStockName());
        assertEquals(10000, stock1.getStockPrice(), 0.1);
    }
}

