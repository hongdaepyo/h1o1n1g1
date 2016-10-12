package java0707_statement;

public class Java031_for {

	public static void main(String[] args) {
		int odd=0; //홀수누적
		int even=0; //짝수누적
		for(int i=1; i<=10; i++){
			
			if(i%2==1){
				odd+=i;
			}else{
				even+=i;
			}
		}
		System.out.printf("짝수누적:%d\n",even);
		System.out.printf("홀수누적:%d\n",odd);

	}//end main()

}//end class
