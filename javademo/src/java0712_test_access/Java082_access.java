package java0712_test_access;

import java0712_static_access.Java080_access;

public class Java082_access extends Java080_access{

	public static void main(String[] args) {
		//Java080_access p=new Java080_access();
		Java082_access p=new Java082_access();
		//private으로 선언된 자원은 외부에서 접근할 수 없다.
		//System.out.printf("Var_private=%d\n",p.var_private);
		//System.out.printf("var_default=%d\n",p.var_default);
		System.out.printf("var_protected=%d\n",p.var_protected);
		System.out.printf("var_public=%d\n",p.var_public);

	}//end main()

}//end class
