package java0722_stream_collection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Java166_stream {

	public static void main(String[] args) {
		/*
		 * DataOutputStream와 DataInputStream
		 * 1. 기본데이터형 단위로 쓰고 읽는스트림이다.
		 * 2. 각 자료형의 크기가 다르므로 출력할때와 입력할때 순서에 주의한다.
		 *
		 */
		
		DataOutputStream ds=null;
		FileOutputStream fs=null;
		FileInputStream is=null;
		DataInputStream di=null;
		
		try {
			fs=new FileOutputStream("./src/java0722_stream_collection/sample.txt");
			ds=new DataOutputStream(fs);
			ds.writeInt(65);//'A'
			ds.writeDouble(10.5);
			ds.writeChar('a');
			ds.writeUTF("java");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ds.close();
				fs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		System.out.println("//////////////////////////////////////////");
		
		try {
			is=new FileInputStream("./src/java0722_stream_collection/sample.txt");
			di=new DataInputStream(is);
			System.out.println(di.readInt());
			System.out.println(di.readDouble());
			System.out.println(di.readChar());
			System.out.println(di.readUTF());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				di.close();
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

	}//end main()

}//end class
