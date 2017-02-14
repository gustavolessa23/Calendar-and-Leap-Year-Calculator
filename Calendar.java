/**
 * This programme contains the main method and is used to call LeapYearCalculator
 * to perform it's methods. 
 * 
 * As better discussed in Javadoc section of LeapYearCalculator.java file,
 * the method isLeapYear(year); takes a year and returns whether it's a leap year or not.
 * The displayCalendar(year) method displays a simple calander of given year.
 * The displayCalendarDays(year) method displays a regular calendar, including correct days of the week.
 * 
 * Author: Gustavo Lessa
 * Student Number: 2016104
 * Date: 15/11/2016
 */

public class Calendar{
	public static void main(String [] args){

		LeapYearCalculator calc = new LeapYearCalculator();

		calc.isLeapYear(2017);
		System.out.println();
		calc.isLeapYear(2016);
		System.out.println();
		calc.isLeapYear(1900);
		System.out.println();
		calc.isLeapYear(2000);
		System.out.println();
		calc.isLeapYear(-400);
		System.out.println();
		calc.displayCalendar(2016);
		System.out.println("");
		calc.displayCalendar(2017);
		System.out.println("");
		calc.displayCalendarDays(2016);
		System.out.println("");
		calc.displayCalendarDays(2017);
	}
}
