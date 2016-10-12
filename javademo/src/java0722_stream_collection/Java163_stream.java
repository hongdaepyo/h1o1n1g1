package java0722_stream_collection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Java163_stream {

	public static void main(String[] args) {
		File file=new File("./src/java0722_stream_collection/song.txt");
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(file, "rw");
			//파일의 끝으로 포인터 위치를 변경한다.
			raf.seek(raf.length());
			String stn=new String("Maroon 5 - Daylight, Sunday morning\r\n");
			raf.writeBytes(stn);
			raf.writeChar(97);//'a'
			raf.writeBytes("\r\n");
			System.out.println("program end");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				raf.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}//end main()

}//end class
