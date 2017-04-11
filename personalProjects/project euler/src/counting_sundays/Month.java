/**
 * 
 */
package counting_sundays;

import java.util.Arrays;

/**
 * @author matt
 *
 */
public class Month {
	private int numberOfDays;
	private String name;
	private int monthNumber;
	private int yearNumber;
	private Day[] daysArray;
	/**
	 * 
	 * @param d the month 1-12
	 * @param y if the given year is a leap year or not
	 * @param n year number
	 */
	public Month(int d,boolean y,int n){
		monthNumber = d;
		yearNumber = n;
		switch (d){
		case 1:
			name = "January";
			numberOfDays = 31;
			break;
		case 2:
			name = "February";
			if(y){
				numberOfDays = 29;
			}
			else
				numberOfDays = 28;
			break;
		case 3:
			name = "March";
			numberOfDays = 31;
			break;
		case 4:
			name = "April";
			numberOfDays = 30;
			break;
		case 5:
			name = "May";
			numberOfDays = 31;
			break;
		case 6:
			name = "June";
			numberOfDays = 30;
			break;
		case 7:
			name = "July";
			numberOfDays = 31;
			break;
		case 8:
			name = "August";
			numberOfDays = 31;
			break;
		case 9:
			name = "September";
			numberOfDays = 30;
			break;
		case 10:
			name = "October";
			numberOfDays = 31;
			break;
		case 11:
			name = "November";
			numberOfDays = 30;
			break;
		case 12:
			name = "December";
			numberOfDays = 31;
			break;
		}
		daysArray = new Day[numberOfDays];
		for(int c = 0; c< daysArray.length;c++){
			daysArray[c] = new Day(c+1,this.monthNumber,this.yearNumber);
		}
	}
	
	/**
	 * @return the numberOfDays
	 */
	public int getNumberOfDays() {
		return numberOfDays;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the daysArray
	 */
	public Day[] getDaysArray() {
		return daysArray;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Month [numberOfDays=" + numberOfDays + ", name=" + name
				+  ", daysArray="
				+ Arrays.toString(daysArray) + "]";
	}
	public static void main (String[] args){
		//Month m = new Month(DayOfWeek.MONDAY,9,false);
		//System.out.println(m);
	}

}
