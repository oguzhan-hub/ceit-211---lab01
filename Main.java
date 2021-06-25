package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int day, month, year;

        System.out.println("Enter two 'modern' dates: month day year");
        System.out.println("For example, January 21, 1939, would be: 1 21 1939");
        System.out.println();
        System.out.println("Modern dates are not before " + Date.MINYEAR + ".");
        System.out.println();

        System.out.println("Enter the first date:");
        // By entering two dates, the following code is repeated.
        // Consider creating a method to do it.
        if (scan.hasNextInt())
        {
            month = scan.nextInt();
        } else {
            // -------I changed this--------
            System.out.println("Illegal input was entered for month");
            return;
        }
        if (scan.hasNextInt())
        {
            day = scan.nextInt();
        } else {
            // -------I changed this--------
            System.out.println("Illegal input was entered");
            return;
        }
        if (scan.hasNextInt())
        {
            year = scan.nextInt();
        } else {
            // -------I changed this--------
            System.out.println("Illegal input was entered for year");
            return;
        }
        Date d1 = new Date(month, day, year);
        if (!d1.valid())
        {
            System.out.println("Date entered is out of range.");
            return;
        }

        System.out.println("Enter the second date:");
        // By entering two dates, the following code is repeated.
        // Consider creating a method to do it.
        if (scan.hasNextInt())
        {
            month = scan.nextInt();
        } else {
            System.out.println("Entered a non-integer value for month");
            return;
        }
        if (scan.hasNextInt())
        {
            day = scan.nextInt();
        } else {
            System.out.println("Entered a non-integer value for day");
            return;
        }
        if (scan.hasNextInt())
        {
            year = scan.nextInt();
        } else {
            System.out.println("Entered a non-integer value for year");
            return;
        }
        Date d2 = new Date(month, day, year);

        if (!d2.valid())
        {
            System.out.println("Date entered is out of range.");
            return;
        } else {
            System.out.println("The number of days between");
            System.out.print(d1 + " and " + d2 + " is ");
            System.out.println(Math.abs(d1.lilian() - d2.lilian()));
        }
    }
}
