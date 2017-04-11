package counting_sundays;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		int c = 1901;
		int b = 0;
		ArrayList<Year> year = new ArrayList<Year>();
		while(c<2001){
			year.add(new Year(c));
			c++;
		}
		for(Year y:year){
			for(Month m:y.getMonths()){
				for(Day d:m.getDaysArray()){
					if(d.getDayNum() == 1 && d.getDay().equals(DayOfWeek.SUNDAY)){
						b++;
					}
				}
			}
		}
		System.out.println(b);
	}

}
