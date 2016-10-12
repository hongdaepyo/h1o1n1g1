package java0720_api;

import java.util.GregorianCalendar;

public class Java146_GregorianCalendar {

	public static void main(String[] args) {
		
		int year=2015;
		GregorianCalendar gre= new GregorianCalendar();
		if(gre.isLeapYear(year))
			System.out.printf("%d년도는 윤년입니다.\n",year);
		else
			System.out.printf("%d년도는 평년입니다.\n",year);

	}//end main()

}//end class
