package java0721_exception_stream.prob;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*[문제]
 * data.txt 파일에는 PRODUCT 테이블의 컬럼 이름들이 저장되어있다. 
 * 이 컬럼 이름들을 Java 의 변수명으로 변환하여 콘솔창에 출력하는
 *  makeVariable() 메소드를 구현하시오. 
 * Java 의 변수명은 camel case 가 적용된 형태로 변환해야 한다
 * 
 * [실행결과]
 * prodNo
 * prodName
 * price
 * amount
 * maker
 * regDate
 */

public class Prob002_stream {
	public static void main(String[] args) {
		String fileName = ".\\src\\java0721_exception_stream\\prob\\data.txt";
		makeVariable(fileName);
	}// end main()

	private static void makeVariable(String fileName) {
		// 구현하세요.
		File file = new File(fileName);
		Scanner sc = null;
		String str = "";
		String st = null;
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				st = new String(sc.nextLine());
				for (int i = 0; i < st.length(); i++) {
					if (st.charAt(i) >= 'A' && st.charAt(i) <= 'Z') {
						str += Character.toLowerCase(st.charAt(i));
					} else if (st.charAt(i) == '_') {
						str += st.charAt(i + 1);
						i++;
					}
				}
				System.out.println(str);
				str = "";
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sc.close();
		}

	}// end makeVariable()
}// end class
