package java0711_method;

/*
 * 출력결과를 참조하여 process()메소드를 구현하시오.
 * 
 * [출력결과]
 * 10 +  5 = 15
 *  3 *  2 = 6
 *  
 */
class Calc {
	private int first;
	private int second;
	private char ope;

	public Calc() {

	}

	public Calc(int first, int second, char ope) {
		this.first = first;
		this.second = second;
		this.ope = ope;
	}

	public int process() {
		// 여기에서 구현하세요./////////////////
		//int res =0;
		switch (ope) {
		case '+':
			return first + second;
			//res = first + second;
			//break;
		case '-':
			return first - second;
		case '*':
			return first * second;
		case '/':
			return first / second;
		}

		return 0;
		//return res;
		//////////////////////////////////
	}

	public void prn() {
		System.out.printf("%2d %c %2d = %d\n", first, ope, second, process());
	}
}// end class

public class Java071_class {

	public static void main(String[] args) {
		Calc[] nfo = new Calc[2];
		nfo[0] = new Calc(10, 5, '+');
		nfo[1] = new Calc(3, 2, '*');

		/*
		 * for(Calc bb : nfo) bb.prn();
		 */
		for (int i = 0; i < nfo.length; i++)
			nfo[i].prn();
	}// end main()

}// end class
