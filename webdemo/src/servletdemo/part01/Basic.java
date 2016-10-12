package servletdemo.part01;

/*java : 로컬프로그램
applet : 클라이언트 컴퓨터에 설치가 된 후 웹에서 실행된다.
servlet : 자바기반의 웹 프로그램 (class)
jsp : 자바기반의 웹 프로그램 (script)
spring : MVC (model2)- 웹을 model2방식을 이용해서 구현할 수 있도록 제공해주는 프레임워크이다.
404-요청 페이지가 없을때
500-문법오류
400-서버오류(
 ex) name="pageNO"
     String pageNo
*/

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:8090/webdemo/Basic/servletdemo.part01.basic
// http://localhost:8090/webdemo/Basic

/*
 * CGI방식 : 클라이언트 요청갯수 만큼 요청페이지를 메모리에 생성하는 방식이다.
 * 웹 어플리케이션 서버 방식 : 한번만 메모리에 생성해서 사용하는 방식이다.
 * 
 * 서블릿 실행순서
 * 1 클라이언트요청이 들어오면 웹서버에서 서블릿컨테이너(tomcat) 요청을 한다
 * 2 요청한 서블릿이 메모리에 로딩이 되였는지를 체크한다.
 * 3 클라이언트가 처음으로 요청한 서블릿이면 메모리에 서블릿을 로딩을 한다.
 *   다른 클라이언트가 이미 요청한 서블릿이면 메모리에 서블릿이 로딩이 되여 있다.
 * 4 메모리에 로딩된 서블릿을 처리를 하고 웹서버에 응답을 한다.
 * 5 웹서버는 요청한 클라이언트에 응답을 한다.
 */
  
/* http://localhost:8090/webdemo/servlet/servletdemo.part01.Basic
 * 프로토콜://서버주소:포트번호/프로젝명(웹어플리케이션)/가상경로/패지키명.클래스명
 */

/*
 * 서블릿구현
 * 1 HttpServlet클래스를 상속받아 클래스를 구현을 한다.
 * 2 요청하는 방식에 따라 get방식일때는 doGet()오버라이딩하고
 *      post방식일때는 doPost()을 오버라이딩한다.
 * 3 HttpServletRequest req : 클라이언트의 정보처리해주는 매개변수이다.
 *   HttpServletResponse resp : 서버가 클라이언트에 응답해줄 정보의 매개변수이다.
 */


@WebServlet("/Basic")
public class Basic extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//클라이언트에 응답 컨텐츠 타입을 지정한다.
		resp.setContentType("text/html");
		
		//클라이언트에 응답할 객체를 생성한다.
		PrintWriter out=resp.getWriter();
		
		out.print("<html>");
		out.print("<head><title>servlet page</title></head>");
		out.print("<body>");
		out.print("<p>Basic Page</p>");
		out.print("</body></html>");
		out.close();
	}//end doGet()

}//end class
