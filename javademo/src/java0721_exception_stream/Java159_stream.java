package java0721_exception_stream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*엔터키 누르면 이뤄지는 작업,(숫자)는 유니코드
 * carriage return : 줄의 처음으로 이동(13) \r
 * line feed : 다음줄로 이동(10) \n
 */

public class Java159_stream {

	public static void main(String[] args) {
		File file=new File("sample.txt");
		/*System.out.println(file.exists());
		System.out.println(file.isFile());
		System.out.println(file.canWrite());*/
		FileWriter fw=null;
		try {
			/*
			 * FileWriter("대상파일", mode)
			 * mode의 값이 true이면 append이고, false이면 update이다.
			 * 생략하면 mode의 값은 false이다.(기본값)
			 */
			fw=new FileWriter(file, true);
			fw.write("java\r\n");  //바로 대상에 쓰지 않고 임시기억장치인 버퍼에 쓴다.
			fw.flush(); //buffer의 내용을 대상file에 보내고 buffer를 clear한다.
			fw.write("test\r\n");
			
			System.out.println("저장종료");
			
			//fw.write(97);
			//fw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fw.close(); //flush + 연결종료
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		

	}//end main()

}//end class
