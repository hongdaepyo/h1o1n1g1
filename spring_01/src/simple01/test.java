package simple01;


class test {
	
	public static int[] test(int[] arr){
				
		for(int i=0;i<arr.length;i++){
			int a=(int)(Math.random()*arr.length);
			arr[i]=arr[a];
		}
		return arr;
	}
	

	public static void main(String args[]) {
		int[] original = {1,2,3,4,5,6,7,8,9};
		System.out.println(java.util.Arrays.toString(original));
		int[] result = test(original);
		System.out.println(java.util.Arrays.toString(result));
	}
}
