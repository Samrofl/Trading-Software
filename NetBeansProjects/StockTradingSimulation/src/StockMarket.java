/**
 * this class is used to model a stock market in our stock market simulation.
 *
 * @author Sam Berkay, Navtej Bhogal
 * @version 1.0, 03 may 2017
 */
public class StockMarket {

    public int month = 1;
    public int day = 1;
    public int weekday = 6;
    public int hour = 0;
    public int minute = 0;
    public String[] weekdays = {"Mon","Tues","Wed","Thu","Fri","Sat","Sun"};
    public boolean isLeapYear=false;
    public boolean holiday = false;
    public MarketType marketType = MarketType.STABLE;
    
    /**
     * General method to increment the time by recursively calling methods.
     * 
     */
    public void incrementTime()
    {
        checkHoliday(); //Check to see whether it is a holiday on the first day of trading 
        incrementMinutes();
    }
    
    /**
     * Specific method to increment the minutes.
     * 
     */
    public void incrementMinutes()
    {
        //Reset minute timer to zero and increase the hour if appropriate.
        if (minute != 45) {
            minute = minute + 15;
        }
        else {
            minute = 0;
            incrementHour();
        }
    }
    
    /**
     * Specific method to increment the hours.
     * 
     */
    public void incrementHour() {
        //Reset hour timer to zero and increase the day if appropriate.
        if (hour!=23){
            hour++;
        }
        else {
            hour = 0;
            incrementDay();
        }
    }
    
    /**
     * Specific method to increment the days
     * 
     */
    public void incrementDay() {
        //If the month has 31 days, reset the day count and increment the month when the end of the month is reached.
        if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day == 31){
            day=1;
            incrementWeekDay();
            incrementMonth();
        }
        //If the month has 30 days, reset the day count and increment the month when the end of the month is reached.
        else if ((month == 4 || month == 6 || month == 9 || month == 11) && day == 30) {
            day=1;
            incrementWeekDay();
            incrementMonth();
        }
        //If the month is february, check to see if it is currently a leap year. If it is - increment the month after the 29th day, if not, the 28th day.
        else if (month == 2) {
            if (day == 28 && getLeapYear() == false){
                day = 1;
                incrementWeekDay();
                incrementMonth();
            }
            else if (day == 29 && getLeapYear() == true) {
                day = 1;
                incrementWeekDay();
                incrementMonth();
            }
            //Increase the day during february if it is not the end of the month.
            else {
                day++;
                incrementWeekDay();
            }
        }
        //Increase the day if it is not the end of the month.
        else {
            day++;
            incrementWeekDay();
        }
        checkHoliday();
    }
    
    /**
     * Increments the weekdays to make add weekend functionality to close markets on the weekend
     * 
     */
    public void incrementWeekDay(){
        weekday++;
        if (weekday == 7) {
            weekday = 0;
        }
        
    }
    
    /**
     * Method to increment the month
     * 
     */
    public void incrementMonth() {
        month++;
    }
    
    /**
     * Method to check whether it is currently a holiday or not.
     * 
     */
    public void checkHoliday() {
        if(weekday == 5 || weekday ==6)
        {
            setHoliday(true);
        }
        //Christmas & Boxing day are holidays
        else if (month == 12 && (day == 25 || day == 26)){
            setHoliday(true);
        }
        //Good Friday && Easter Monday are holidays
        else if(month == 4 && (day == 14 || day == 17)) {
            setHoliday(true);
        }
        else {
            setHoliday(false);
        }
        
    }
    
    //Setter methods.
    
    /**
     * This method is used to set the value of the holiday attribute to either true or false
     * 
     * @param holiday this is the boolean value which will be assigned to the holiday attribute
     */
    public void setHoliday(boolean holiday) {
        this.holiday = holiday;
    }
    
    //Getter methods.
    
    /**
     * this method returns the current month attribute value
     * 
     * @return this is the current month attribute value
     */
    public int getMonth() {
        return month;
    }
    
    /**
     * this method returns the current day attribute value
     * 
     * @return this is the current day attribute value
     */
    public int getDay() {
        return day;
    }

    /**
     * this method returns the current hour attribute value
     * 
     * @return this is the current hour attribute value
     */
    public int getHour() {
        return hour;
    }

    /**
     * this method returns the current minute attribute value
     * 
     * @return this is the current minute attribute value
     */
    public int getMinute() {
        return minute;
    }

    /**
     * this method returns the current isLeapYear attribute value
     * 
     * @return this is the current isLeapYear attribute value
     */
    public boolean getLeapYear() {
        return isLeapYear;
    }
    
    /**
     * this method returns the current weekday attribute value
     * 
     * @return this is the current weekday attribute value
     */
    public int getWeekday() {
        return weekday;
    }
    
    /**
     * this method returns the current weekdays attribute value
     * 
     * @return this is the current weekdays attribute value
     */
    public String[] getWeekdays() {
        return weekdays;
    }
    
    /**
     * This method returns the correct string for the day of the week on any given day in the year.
     * 
     * @param array this is an string array containing the days of the week
     * @param i this is the number of the day in the year
     * @return a name of a day as a string
     */
    public String getWeekdayName(String[] array, int i) {
        return array[i];
    }

    /**
     * this method returns the current holiday attribute value
     * 
     * @return this is the current holiday attribute value
     */
    public boolean isHoliday() {
        return holiday;
    }

    /**
     * this method returns the current marketType attribute value
     * 
     * @return this is the current marketType attribute value
     */
    public MarketType getMarketType() {
        return marketType;
    }
}
