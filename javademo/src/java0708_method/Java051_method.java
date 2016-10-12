package java0708_method;

public class Java051_method {

	public static void main(String[] args) {
		int[] data = new int[] { 2, 10 };
		System.out.println(max(data));

	}// end main()

	public static int max(int[] num) {
		if (num[0] > num[1])
			return num[0];
		else if (num[0] < num[1])
			return num[1];
		else
			return -1;
	}
}// end class
