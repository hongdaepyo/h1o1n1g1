package java0725_collection.prob;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSplitPaneUI;

/*
 * [문제]
 * phone.txt파일에 저장된 값들을  phoneProduct()메서드에서
 * SmartPhone에 저장한 후 ArrayList에 추가한후 리턴하고,
 * phoneList()메소드에서 프로그램 실행결과처럼 출력하는 프로그램을
 * 구현하시오.
 * 
 * [프로그램 실행결과]
 * << 1 번째 상품 >>
	제품 아이디 : PROD-00001
	제품명 : 아이폰5
	가격 : 940000
	수량 : 4
	제조사 : 애플
   << 2 번째 상품 >>
	제품 아이디 : PROD-00002
	제품명 : 갤럭시S
	가격 : 860000
	수량 : 3
	제조사 : 삼성전자

 */
public class Prob003_ArrayList {

	public static void main(String[] args) {
		String pathFile=".\\src\\java0725_collection\\prob\\phone.txt";
		ArrayList<SmartPhone> phoneList = phoneProduct(pathFile);
		prnDisplay(phoneList);
	}//end main()
	
	private static ArrayList<SmartPhone> phoneProduct(String pathFile) {
		// phone.txt파일의 데이터를 ArrayList에 저장한후 리턴하는 프로그램을 구현하시오.
		
		ArrayList<SmartPhone> sp=new ArrayList<SmartPhone>();
		Scanner sc=null;
		try {
			sc=new Scanner(new File(pathFile));
			int i=0;
			while(sc.hasNextLine()){
				String[] str =sc.nextLine().split(":");
				sp.add(new SmartPhone());
				sp.get(i).setProductId(str[0]);
				sp.get(i).setName(str[1]);
				sp.get(i).setPrice(Integer.parseInt(str[2]));
				sp.get(i).setAmount(Integer.parseInt(str[3]));
				sp.get(i).setMaker(str[4]);
				i++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sc.close();
		}
		
		
		return sp;
	}//end phoneProduct( )
	
	private static void prnDisplay(ArrayList<SmartPhone> phoneList){
		//phoneList매개변수의 저장된 값을 출력하는 프로그램을 구현하시오.
		int cnt=0;
		for(SmartPhone sp:phoneList){
			cnt++;
			System.out.printf("<< %d 번째 상품>>\n",cnt);
			System.out.println("제품 아이디 : "+sp.getProductId());
			System.out.println("제품명 : "+sp.getName());
			System.out.println("가격 : "+sp.getPrice());
			System.out.println("수량 : "+sp.getAmount());
			System.out.println("제조사 : "+sp.getMaker());
			
			
		}

	}//end prnDisplay( )

}//end class











