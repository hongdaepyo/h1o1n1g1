package java0725_collection;

import java.util.ArrayList;

public class Java176_ArrayList {

	public static void main(String[] args) {
		ArrayList<String> aList = new ArrayList<String>();
		aList.add(new String("java"));
		aList.add(new String("jsp"));
		aList.add(new String("spring"));
		prnDisplay(aList);

	}// end main()

	public static void prnDisplay(ArrayList<String> aList) {
		// aList의 요소에서 'j'가 포함되어 있는 요소만 출력하는 프로그램을 구현하세요.
		System.out.println("선생님 답 1");
		for (int i = 0; i < aList.size(); i++) {
			for (int j = 0; j < aList.get(i).length(); j++) {
				if (aList.get(i).charAt(j) == 'j')
					System.out.println(aList.get(i));
				break;
			}
		}
		System.out.println("선생님 답 2");
		for (int i = 0; i < aList.size(); i++) {
			// contains()는 인자값이랑 일치하는게 있으면 true 아니면 false를 리턴한다.
			if (aList.get(i).contains("j"))
				System.out.println(aList.get(i));
		}

		System.out.println("내 답");
		for (int i = 0; i < aList.size(); i++)
			if (aList.get(i).indexOf("j") != -1)
				System.out.println(aList.get(i));
	}

}// end class
