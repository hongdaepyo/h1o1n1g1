package java0718_api;

import javax.xml.crypto.Data;

public class Java116_String {

	public static void main(String[] args) {
		String sn="127.0.0.1:8080";
		
		//indexOf, substring 사용
		/*System.out.println("ip:"+sn.substring(0,sn.indexOf(':')));
		System.out.println("port:"+sn.substring(sn.indexOf(':')+1));*/
		
		//split 사용
		String[] arr=sn.split(":");
		System.out.println("ip:"+arr[0]);
		System.out.println("port:"+arr[1]);
		
	}//end main()

}//end class
