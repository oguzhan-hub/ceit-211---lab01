package com.company;

public class Date {
    protected int year, month, day;
    public static final int MINYEAR = 1583;

    // Constructor
    public Date() {
        month = 0;
        day = 0;
        year = 1583;
    }

    // Constructor
    public Date(int newMonth, int newDay, int newYear) {
        month = newMonth;
        day = newDay;
        year = newYear;
    }

    // Observers
    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int lilian() {
        // Returns the Lilian Day Number of this date.
        // Precondition: This Date is a valid date after 10/14/1582.
        //
        // Computes the number of days between 1/1/0 and this date as if no calendar
        // reforms took place, then subtracts 578,100 so that October 15, 1582 is day 1.

        final int subDays = 578100;  // number of calculated days from 1/1/0 to 10/14/1582

        int numDays = 0;

        // Add days in years.
        numDays = year * 365;

        // Add days in the months.
        if (month <= 2)
            numDays = numDays + (month - 1) * 31;
        else
            numDays = numDays + ((month - 1) * 31) - ((4 * (month - 1) + 27) / 10);

        // Add days in the days.
        numDays = numDays + day;

        // Take care of leap years.
        numDays = numDays + (year / 4) - (year / 100) + (year / 400);

        // Handle special case of leap year but not yet leap day.
        if (month < 3) {
            if ((year % 4) == 0) numDays = numDays - 1;
            if ((year % 100) == 0) numDays = numDays + 1;
            if ((year % 400) == 0) numDays = numDays - 1;
        }

        // Subtract extra days up to 10/14/1582.
        numDays = numDays - subDays;
        return numDays;
    }

    public boolean valid() {
        if (year <= Date.MINYEAR || this.month < 1 || this.month > 12) {
            System.out.println("You entered a 'pre-modern' date.");
            return false;
        }
        switch (this.month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (this.day >= 1 && this.day <= 31) return true;
                break;

            case 4:
            case 6:
            case 9:
            case 11:
                if (this.day >= 1 && this.day <= 30) return true;
                break;

            case 2:
                int febDays = 28;
                if ((this.year % 4 == 0 && this.year % 100 != 0) || (this.year % 400 == 0)) febDays = 29;
                if (this.day >= 1 && this.day <= febDays) return true;
                break;
        }
        return false;
    }

    @Override
    public String toString()
    // Returns this date as a String.
    {
        //return(month + "/" + day + "/" + year);
        String mon;
        switch (month) {
            case 1:
                mon = "January";
                break;
            case 2:
                mon = "February";
                break;
            case 3:
                mon = "March";
                break;
            case 4:
                mon = "April";
                break;
            case 5:
                mon = "May";
                break;
            case 6:
                mon = "June";
                break;
            case 7:
                mon = "July";
                break;
            case 8:
                mon = "August";
                break;
            case 9:
                mon = "September";
                break;
            case 10:
                mon = "October";
                break;
            case 11:
                mon = "November";
                break;
            case 12:
                mon = "December";
                break;
            default:
                mon = "unkown";
        }
        return (mon + " " + day + ", " + year);
    }
}
