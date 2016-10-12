package java0721_exception_stream;

public class Java149_exception {

	public static void main(String[] args) {
		String data1="12";
		String data2="0";
		try{
		 int x=Integer.parseInt(data1);
		 int y=Integer.parseInt(data2);
		 int res=x/y;
		 //다중 catch 쓸때에는 상속관계에 있는 exception들은 가장 하위항목을 위에 상위 항목을 아래에 씀
		}catch(NumberFormatException ex){
			System.out.println("숫자를 입력하세요.");
		}catch(ArithmeticException ex){
			System.out.println("분모는 0보다 큰 수를 입력하세요.");
		}catch(RuntimeException ex){
			System.out.println(ex.toString());
		}
		
	}//end main()

}//end class
