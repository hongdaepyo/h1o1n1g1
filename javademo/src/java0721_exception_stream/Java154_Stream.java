package java0721_exception_stream;

import java.io.IOException;
import java.io.InputStream;

public class Java154_Stream {

	public static void main(String[] args) {
		System.out.println("데이터 입력");
		
		InputStream is=System.in;
		
		try {
			//한바이트를 읽어와 유니코드로 리턴한다.
			int line=is.read();
			System.out.println(line);
			System.out.println((char)line);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		

	}//end main()

}//end class
