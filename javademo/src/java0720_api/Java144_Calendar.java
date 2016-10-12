package java0720_api;

import java.util.Calendar;

abstract class Test{
	public static Test getInstance(){
		return null;
	}
}


class TestExam extends Test{
	public static Test getInstance(){
		Test tt= new TestExam();
		return tt;
	}
}

public class Java144_Calendar {
	
	public static void main(String[] args){
		Test tt=Test.getInstance();
		/*
		 * Calendar은 추상클래스이므로 객체생성을 할 수 없다.
		 */
		Calendar cal=Calendar.getInstance();
		int year=cal.get(Calendar.YEAR);
		//Month은 1월 일때 0으로 리턴한다.
		int month=cal.get(Calendar.MONTH)+1;
		System.out.println(month);
		int date=cal.get(Calendar.DATE);
//		int hour=cal.get(Calendar.HOUR); 12시간
		int hour=cal.get(Calendar.HOUR_OF_DAY);
		int minute=cal.get(Calendar.MINUTE);
		int second=cal.get(Calendar.SECOND);
		
		System.out.printf("%d-%d-%d %d:%d:%d\n",year,month,date,hour,minute,second);
		
		//이번달의 마지막일 리턴
		System.out.println(cal.getMaximum(Calendar.DATE));
		
		//오늘의 요일 리턴(일요일 -> 1)
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		
		//오늘을 기준으로 5일전의 날짜를 리턴
		cal.add(Calendar.DATE, -5);
		System.out.println(cal.toString());
		
		cal.set(Calendar.DATE,15);
		System.out.println(cal.get(Calendar.DATE));
		
		cal.set(2015,4,20);//2015-5-20
		System.out.println(cal.toString());
		
		
	}//end main()
}//end class
