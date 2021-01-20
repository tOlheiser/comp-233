/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personprogram;

/**
 *
 * @author Owner
 */
public class Date {
    private int month;
    private int day;
    private int year;
    private int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Date(int theMonth, int theDay, int theYear) {
        this.month = theMonth;
        this.day = theDay;
        this.year = theYear;
    }
    
    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
    
    public int getYear() {
        return year;
    }
    
    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            this.month = 1;
        } else {
            this.month = month;
        }
    }
    
    public void setDay(int day) {
        // first check if its a leap year
        if (year %100 == 0) {
            if (year % 400 == 0) {
                days[2] = 29;
            }
        } else if (year % 4 == 0) {
            days[2] = 29;
        } 
        
        if (day > days[month]) {
            // not good! set default day to 1
            this.day = 1;
        } else {
            // day is valid
            this.day = day;
        }
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    public String toString() {
        String fullDate;
        fullDate = String.format("%d/%d/%d", month, day, year);
        return fullDate;
    }
}
