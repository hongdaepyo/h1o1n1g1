package servletdemo.part02;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginPro")
public class LoginProController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//post방식일때 한글처리(파라미터 값을 받아 오기 전에 처리해준다)
		req.setCharacterEncoding("UTF-8"); //id와 password는 한글을 사용하지 않기 때문에 여기서는 불필요한 부분
		
		MemberDTO dto = new MemberDTO();
		String id=req.getParameter("id");
		dto.setId(id);
		//req.setAttribute("id", id);
		
		String password=req.getParameter("password");
		dto.setPassword(password);
		//req.setAttribute("password", password);
		
		RequestDispatcher dis=req.getRequestDispatcher("/servletview/part02/res.jsp");
		req.setAttribute("dto", dto);
		dis.forward(req, resp);
	}//end dopost()
	
}//end class
