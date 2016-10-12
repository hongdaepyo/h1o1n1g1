package java0706_statement;

public class Java026_switch {

	public static void main(String[] args) {
		int month =13;
		int lastDay = -1;
		
		switch(month){
		case 1: lastDay = 31; break;
		case 2: lastDay = 28; break;
		case 3: lastDay = 31; break;
		case 4: lastDay = 30; break;
		case 5: lastDay = 31; break;
		case 6: lastDay = 30; break;
		case 7: lastDay = 31; break;
		case 8: lastDay = 31; break;
		case 9: lastDay = 30; break;
		case 10: lastDay = 31; break;
		case 11: lastDay = 30; break;
		case 12: lastDay = 31;
		}
		
		/*switch(month){
		case 2: lastDay = 28; break;
		case 1: 
		case 3: 
		case 5: 
		case 7: 
		case 8: 
		case 10: 
		case 12: lastDay = 31; break;
		case 4:
		case 6:
		case 9:
		case 11: lastDay = 30; break;
		}
		*/
		
		if(!(month>=1&&month<=12)){
			System.out.println("잘못 입력되었습니다. 다시 시작하세요");
		}else{
			System.out.printf("%d월의 마지막 일은 %d입니다.",month,lastDay);
		}

	}//end main()

}//end class
