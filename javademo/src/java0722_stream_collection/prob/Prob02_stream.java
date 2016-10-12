package java0722_stream_collection.prob;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/*
 * [문제]
 *  jumsu.txt 파일로부터 학생의 점수를 읽어들여 총점과 평균을 jumsu.txt 파일 끝에 덧붙여 출력하는 프로그램을 작성하시오.
    단, 평균점수는 소수점 첫 번째 자리까지만 남기고 나머지는 잘라낸다.(truncate) 
    
    [프로그램 실행결과]
    태연:65
	수영:97
	제시카:100
	티파니:86
	써니:88
	총점:436
	평균:87.2
 */
public class Prob02_stream {
	public static void main(String[] args) {
		// 프로그램을 구현하시오.
		File fr = new File(".\\src\\java0722_stream_collection\\prob\\jumsu.txt");
		FileWriter fw = null;
		FileReader FR = null;
		RandomAccessFile raf = null;
		Scanner sc = null;
		String str = null;
		int jumsu = 0;
		int total = 0;
		int count = 0;
		double avg = 0;

		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;
		
		/*try {
			raf = new RandomAccessFile(fr, "rw");
			sc = new Scanner(fr);
			while (sc.hasNextLine()) {
				str = sc.nextLine();
				if (str.matches(".*:.*")) {
					str = new String(str.getBytes("UTF-8"), "ISO-8859-1");
					sb.append(str + "\r\n");
					jumsu = Integer.parseInt(str.substring(str.indexOf(':') + 1));
					count++;
					total += jumsu;
				}

			}
			avg = (double) total / count;
			avg = Math.round(avg * 10);
			avg = avg / 10;

			String stn = "총점:" + total;
			String stn2 = "평균:" + avg;

			stn = new String(stn.getBytes("UTF-8"), "ISO-8859-1");
			stn2 = new String(stn2.getBytes("UTF-8"), "ISO-8859-1");
			sb.append(stn + "\r\n" + stn2);
			raf.writeBytes(sb.toString());

		} catch (FileNotFoundException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sc.close();
		}*/
		 

		try {
			fw = new FileWriter(fr, true);
			sc = new Scanner(fr);
			while (sc.hasNextLine()) {
				str = sc.nextLine();
				if (str.matches(".*:.*")) {
					jumsu = Integer.parseInt(str.substring(str.indexOf(':') + 1));
					count++;
					total += jumsu;

				} else {
					break;
				}

			}
			avg = (double) total / count;
			avg = Math.round(avg * 10);
			avg = avg / 10;
			fw.write("총점:" + total + "\r\n");
			fw.write("평균:" + avg);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}// end main()
}// end class
