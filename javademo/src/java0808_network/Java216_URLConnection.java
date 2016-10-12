package java0808_network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/*
 * URLConnection : 어플리케이션과 URL간의 통신연결을 나타내는 클래스의 최상위 클래스이다.
 * HttpURLConnection : URLConnection추상클래스를 상속받아 구현해놓은 클래스이다.
 *                    URL클래스에서제공하는 openConnection()메소드를 통해서
 *                     HTTPURLConnection클래스의 객체를 반환받는다.
 *                    URLConnection클래스를 통해서 연결하고자 하는 자원에 접근하고 읽고
 *                    쓰기를 할 수 있다.
 */

public class Java216_URLConnection {

	public static void main(String[] args) {
		URL url;
		try {
			//url = new URL("http://www.naver.com");
			url = new URL("http://map.naver.com/?query=%EC%B9%B4%EC%84%BC%ED%84%B0&type=SITE_1");
			URLConnection conn=url.openConnection();
			InputStreamReader is=new InputStreamReader(conn.getInputStream());
			BufferedReader br=new BufferedReader(is);
			String line="";
			while((line=br.readLine())!=null){
				System.out.println(line);
			}
			br.close();
			
			
			
			
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		

	}//end main()

}//end class
