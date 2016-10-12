package java0706_statement;
/*
 *
 * [출력결과]
 * channel = 7, station = "KBS"  => 닥터포스터
 * channel = 9, station = "KBS"  => 국수의신
 * station = "MBC"  => 몬스터
 * station = "EBS"   => 한국기행
 *
 */
public class Java023_if {

	public static void main(String[] args) {
		int channel = 9;
		String station = "EBS";
		
		if(station == "KBS"){
			if(channel == 7){
				System.out.println("닥터포스트");
			}else if (channel == 9){
				System.out.println("국수의신");
			}
		}else if (station == "MBC"){
			System.out.println("몬스터");
		}else if (station == "EBS"){
			System.out.println("한국기행");
		}
		

	}//end main()

}//end class
