

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class StockMarketTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StockMarketTest
{
    /**
     * Default constructor for test class StockMarketTest
     */
    public StockMarketTest()
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
    public void TestMinute()
    {
        StockMarket stockMar1 = new StockMarket();
        assertEquals(0, stockMar1.getMinute());
        stockMar1.incrementMinutes();
        assertEquals(15, stockMar1.getMinute());
        stockMar1.incrementMinutes();
        assertEquals(30, stockMar1.getMinute());
    }

    @Test
    public void TestMarketType()
    {
        StockMarket stockMar1 = new StockMarket();
        MarketType sTABLE1 = stockMar1.getMarketType();
        assertEquals("STABLE", sTABLE1);
    }

    @Test
    public void TestMonth()
    {
        StockMarket stockMar2 = new StockMarket();
        stockMar2.incrementMonth();
        assertEquals(2, stockMar2.getMonth());
        stockMar2.incrementDay();
        assertEquals(2, stockMar2.getDay());
        stockMar2.incrementDay();
        stockMar2.incrementDay();
        stockMar2.incrementDay();
        stockMar2.incrementDay();
        stockMar2.incrementDay();
        stockMar2.incrementDay();
        stockMar2.incrementDay();
        stockMar2.incrementDay();
        stockMar2.incrementDay();
        stockMar2.incrementDay();
        stockMar2.incrementDay();
        stockMar2.incrementDay();
        stockMar2.incrementDay();
        stockMar2.incrementDay();
        stockMar2.incrementDay();
        stockMar2.incrementDay();
        stockMar2.incrementDay();
        stockMar2.incrementDay();
        stockMar2.incrementDay();
        stockMar2.incrementDay();
        stockMar2.incrementDay();
        stockMar2.incrementDay();
        stockMar2.incrementDay();
        stockMar2.incrementDay();
        stockMar2.incrementDay();
        stockMar2.incrementDay();
        stockMar2.incrementDay();
        stockMar2.incrementDay();
        assertEquals(2, stockMar2.getDay());
        assertEquals(3, stockMar2.getMonth());
    }

    @Test
    public void TestWeekDay()
    {
        StockMarket stockMar2 = new StockMarket();
        stockMar2.incrementWeekDay();
        assertEquals(0, stockMar2.getWeekday());
        stockMar2.incrementWeekDay();
        stockMar2.incrementWeekDay();
        assertEquals(2, stockMar2.getWeekday());
    }

    @Test
    public void TestHoliday()
    {
        StockMarket stockMar3 = new StockMarket();
        stockMar3.incrementMonth();
        stockMar3.incrementMonth();
        stockMar3.incrementMonth();
        assertEquals(4, stockMar3.getMonth());
        stockMar3.incrementDay();
        stockMar3.incrementDay();
        stockMar3.incrementDay();
        stockMar3.incrementDay();
        stockMar3.incrementDay();
        stockMar3.incrementDay();
        stockMar3.incrementDay();
        stockMar3.incrementDay();
        stockMar3.incrementDay();
        stockMar3.incrementDay();
        stockMar3.incrementDay();
        stockMar3.incrementDay();
        stockMar3.incrementDay();
        assertEquals(14, stockMar3.getDay());
        assertEquals("ture", stockMar3.isHoliday());
    }

    @Test
    public void TestWeekday()
    {
        StockMarket stockMar2 = new StockMarket();
        stockMar2.incrementWeekDay();
        stockMar2.incrementWeekDay();
        stockMar2.incrementWeekDay();
        stockMar2.incrementWeekDay();
        assertEquals(3, stockMar2.getWeekday());
        stockMar2.incrementWeekDay();
        stockMar2.incrementWeekDay();
        assertEquals(5, stockMar2.getWeekday());
        assertEquals("true", stockMar2.isHoliday());
    }

    @Test
    public void TestHour()
    {
        StockMarket stockMar2 = new StockMarket();
        stockMar2.incrementHour();
        stockMar2.incrementHour();
        stockMar2.incrementHour();
        stockMar2.incrementHour();
        stockMar2.incrementHour();
        stockMar2.incrementHour();
        stockMar2.incrementHour();
        stockMar2.incrementHour();
        stockMar2.incrementHour();
        stockMar2.incrementHour();
        stockMar2.incrementHour();
        stockMar2.incrementHour();
        stockMar2.incrementHour();
        stockMar2.incrementHour();
        stockMar2.incrementHour();
        stockMar2.incrementHour();
        stockMar2.incrementHour();
        stockMar2.incrementHour();
        stockMar2.incrementHour();
        stockMar2.incrementHour();
        stockMar2.incrementHour();
        assertEquals(21, stockMar2.getHour());
        assertEquals(1, stockMar2.getDay());
        stockMar2.incrementHour();
        stockMar2.incrementHour();
        stockMar2.incrementHour();
        assertEquals(0, stockMar2.getHour());
        assertEquals(2, stockMar2.getDay());
    }
}









