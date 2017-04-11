/**
 * 
 */
package counting_sundays;

/**
 * @author matt
 *
 */
public class Day {
	private DayOfWeek day;
	private int dayNum;
	private int month;
	private int year;
	public Day(int day,int month, int year){
		dayNum = day;
		this.month = month;
		this.year = year;
		this.day = findDayOfWeek();
	}
	private DayOfWeek findDayOfWeek(){
		int q = dayNum;
        int m = month;
        int y = year;

        if (m < 3) {
            m += 12;
            y -= 1;
        }

        int k = y % 100;
        int j = y / 100;

        int dayOfWeek = (((q + (((m + 1) * 26) / 10) + k + (k / 4) + (j / 4)) +
            (5 * j))+5) % 7;
		switch (dayOfWeek){
		case 6:
			return DayOfWeek.SUNDAY;
		case 0:
			return DayOfWeek.MONDAY;
		case 1:
			return DayOfWeek.TUESDAY;
		case 2:
			return DayOfWeek.WEDNESDAY;
		case 3:
			return DayOfWeek.THURSDAY;
		case 4:
			return DayOfWeek.FRIDAY;
		case 5:
			return DayOfWeek.SATURDAY;
		default:
				return null;
		}
	}
	/**
	 * @return the day
	 */
	public DayOfWeek getDay() {
		return day;
	}
	/**
	 * @return the dayNum
	 */
	public int getDayNum() {
		return dayNum;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Day [day=" + day + ", dayNum=" + dayNum + "]";
	}
	public static void main(String [] args){
		Day n = new Day(4,3,1990);
		System.out.println(n.getDay());
	}

}

