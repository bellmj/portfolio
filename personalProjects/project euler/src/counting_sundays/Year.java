/**
 * 
 */
package counting_sundays;

import java.util.Arrays;

/**
 * @author matt
 *
 */
public class Year {
	
	private boolean isLeapYear = false;
	private int year;
	private Month[] months;
	/**
	 * 
	 * @param x the Year to create AD
	 */
	public Year(int x){
		months = new Month[12];
		year = x;
		if((x%4==0&&(x%100!=0))||x%400==0){
			isLeapYear = true;
		}
		
		for(int c = 1;c<=12;c++){
				months[c-1] = new Month(c,isLeapYear,year);
			
		}
	}
	public static void main (String[] args){
		Year y = new Year(2002);
		System.out.println(""+ y.months[0].getDaysArray()[1]);
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Year [isLeapYear=" + isLeapYear + ", year=" + year
				+ ", months=" + Arrays.toString(months) + "]";
	}
	/**
	 * @return the isLeapYear
	 */
	public boolean isLeapYear() {
		return isLeapYear;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @return the months
	 */
	public Month[] getMonths() {
		return months;
	}

}
