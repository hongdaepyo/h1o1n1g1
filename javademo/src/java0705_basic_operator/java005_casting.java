package java0705_basic_operator;
/*
 * 형변환(casting)
 * 1 값의 타입을 다른타입으로 변환하는 것이다.
 * 2  묵시적형변환
 *     작은 값의 데이터 타입을 큰 값의 데이터 타입으로 변환할때 발생한다.
 *     int num;
 *     short data=50;
 *     num=data;
 *     
 *    명시적형변환
 *    큰 값의 데이터 타입을 작은 값의 데이터 타입으로 변화할때 발생한다.
 *    double paran=10.5;
 *    num=(int)paran;
 */

public class java005_casting {

	public static void main(String[] args) {
		int numX=5;
		double res=numX; //묵시적 형변환 double>int
		System.out.println("res:"+res);
		//""는 안에는 문자열
		
		short pa=(short)numX; //명시적 형변환 short<int
		System.out.println("pa:"+pa);

	}// end main()

}// end class
