package java0707_statement;

public class Java043_array {

	public static void main(String[] args) {
		                              
		int[] data1 = new int[3]; //0 기본형
		long[] data2 = new long[3];  //0L
		float[] data3 = new float[3];  //0.0F
		double[] data4 = new double[3]; // 0.0
		char[] data5 = new char[3]; //\u0000(공백)
		boolean[] data6 = new boolean[3]; //false
		String[] data7 = new String[3]; //null
		
		
		for(int i=0; i<data7.length; i++){
			System.out.println(data7[i]);
		}
		

	}//end main()

}//end class
