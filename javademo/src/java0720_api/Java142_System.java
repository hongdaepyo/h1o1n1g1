package java0720_api;


public class Java142_System {

	public static void main(String[] args) {
		int[] arr1={1,5,2,4};
		int[] arr2={6,3,9,7,8};
		int[] arr3=process(arr1, arr2);
		for(int data: arr3)
			System.out.printf("%3d",data);
		process(arr1, arr2);
		

	}//end main()
	
	public static int[] process(int[] arr1, int[] arr2){
		int[] arr3=new int[arr1.length+arr2.length];
		/*for(int i=0;i<arr3.length;i++){
			if(i>=arr1.length){
					arr3[i]=arr2[i-(arr1.length)];
				}else if(i<arr1.length){
					arr3[i]=arr1[i];
				}	
			}*/
		/*System.out.println("///////////아래는 선생님 답////////////////////////////");
		for (int i=0;i<arr1.length;i++){
			arr3[i]=arr1[i];
		}
		for (int i=0;i<arr2.length;i++){
			arr3[arr1.length+i]=arr2[i];
		}
		return arr3;*/
		//src, srcPos, dest, destPos, length
		//arr1을 0번째 인덱스부터 arr3의 0번째 인덱스에 arr1.length만큼 넣어줘라
		System.arraycopy(arr1, 0, arr3, 0, arr1.length);
		//arr2를 0번째 인덱스부터 arr3의 arr1.length번째 인덱스에 arr2.length만큼 넣어줘라
		System.arraycopy(arr2, 0, arr3, arr1.length, arr2.length);
		return arr3;
	}//end process()

}//end class
