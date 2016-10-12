package cookiedemo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * cookie(쿠키) : 클라이언트 정보를 클라이언트 컴퓨터에 저장한다.
 * 				 서버에 페이지를 요청할때 cookie에 저장된 데이터를 전송한다.
 *               cookie생성은 서버에서 한다.
 */
@WebServlet("/makeCookie")
public class MakeCookie extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//쿠키생성
		Cookie cookie = new Cookie("cookiekey","cookieValue");
		cookie.setPath("/"); // '/' 아래의 경로페이지를 호출할때 cookie값이 전달됨.
		cookie.setMaxAge(60*60); //쿠키유효시간 ->1시간
		resp.addCookie(cookie); //쿠키를 클라이언트에 응답
		RequestDispatcher dis=req.getRequestDispatcher("/cookieview/makeCookie.jsp");
		dis.forward(req, resp);
	}

}//end class
