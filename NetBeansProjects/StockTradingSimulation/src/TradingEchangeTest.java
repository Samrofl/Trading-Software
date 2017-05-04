

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TradingEchangeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TradingEchangeTest
{
    /**
     * Default constructor for test class TradingEchangeTest
     */
    public TradingEchangeTest()
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
    public void TestTradingEcxhange()
    {
        TradingExchange tradingE1 = new TradingExchange();
        tradingE1.setShareIndex(100);
        assertEquals(100, tradingE1.getShareIndex(), 0.1);
        tradingE1.setShareIndex(200);
        assertEquals(200, tradingE1.getShareIndex(), 0.1);
    }
}


