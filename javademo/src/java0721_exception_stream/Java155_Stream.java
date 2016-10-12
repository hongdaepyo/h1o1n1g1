package java0721_exception_stream;

import java.io.IOException;
import java.io.InputStream;
/*엔터키 누르면 이뤄지는 작업,(숫자)는 유니코드
 * carriage return : 줄의 처음으로 이동(13)
 * line feed : 다음줄로 이동(10)
 */
public class Java155_Stream {

	public static void main(String[] args) {
		InputStream is=System.in;
		System.out.print("이름: ");
		int data;
		
		try {
			while((data=is.read())!=10){
				System.out.println((char)data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}//end main()

}//end class
