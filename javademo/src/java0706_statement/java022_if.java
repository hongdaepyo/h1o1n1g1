package java0706_statement;

/*각 월의 마지막일
 * 1 3 5 7 8 10 12 => 31
 * 4 6 9 11 => 30
 * 2 => 28
 * 
 * [출력결과]
 * 4월의 마지막 일은 30입니다.
 * 
 * if(조건식){
 * lastDay = 31;
 * }else if (조건식){
 * lastDay = 30;
 * }else if (조건식){
 * lastDay = 28;
 * }
 * if(lastDay==-1){
 * System.out.println("잘못 입력되었습니다. 다시 시작하세요.");
 * }else{
 * System.out.printf("%d월의 마지막 일은 %d입니다.",month,lastDay);
 * }
 */
public class java022_if {

	public static void main(String[] args) {
		int month = 0;
		int lastDay = -1;
		if (month == 2) {
			lastDay = 28;
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			lastDay = 30;
		} else {
			lastDay = 31;
		}
		//if(lastDay==-1)
		if(!(month>=1&&month<=12)){
			System.out.println("잘못 입력되었습니다. 다시 시작하세요.");
		}else{
		System.out.printf("%d월의 마지막 일은 %d입니다.", month, lastDay);
		}
	}// end main()

}// end class
