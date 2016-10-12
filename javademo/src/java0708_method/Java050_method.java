package java0708_method;

public class Java050_method {
	static int[] num = new int[] {3, 5, 9};
	
	public static void main(String[] args) {
		//int data=process();
		//System.out.println(data);
		System.out.println(process());
		
	}//end main()

	public static int process(){
		int sum=0;
		
		for(int i=0;i<num.length;i++){
			sum+=num[i];
		}
		return sum;
	}
}//end class
