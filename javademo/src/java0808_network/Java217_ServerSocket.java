package java0808_network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 소켓 프로그래밍 : 소켓을 이용한 통신 프로그래밍을 의미한다.
 * 소켓(socket) : 프로세스간의 통신에 사용되는 양쪽 끝단을 의미한다.
 *               서로 멀리 떨어진 두 사람이 통신하기 위해서 전화기가
 *               필요한 것처럼, 프로세스간의 통신을 위해서는 소켓이 필요하다.
 * 서버소켓 : 포트번호를 열어서 서버소켓을 실행한다.
 *                
 */

public class Java217_ServerSocket {

	public static void main(String[] args) {
		try {
			//포트번호를 열어서 ServerSocket을 생성한다.
			ServerSocket server = new ServerSocket(7777);
			
			System.out.print("대기상태:");
			//클라이언트의 요청이 올때까지 대기하고 있다.
			Socket socket=server.accept();
			
			System.out.println(socket.getLocalAddress());
			InputStream is=socket.getInputStream();
			InputStreamReader ir=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(ir);
			System.out.println(br.readLine());
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}//end main()

}//end class
