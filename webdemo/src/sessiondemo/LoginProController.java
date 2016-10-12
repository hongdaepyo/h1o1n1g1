package sessiondemo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logPro")
public class LoginProController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String pass=req.getParameter("pass");
		MemDTO dto=new MemDTO();
		dto.setId(id);
		dto.setPass(pass);
		
		MemDAO dao=MemDAO.getInstance();
		int cnt=dao.memCheck(dto);
		if(cnt==1){
			HttpSession session=req.getSession();
			session.setAttribute("logOk", id);
			session.setMaxInactiveInterval(30*60); //30분 세션유지 시간
			resp.sendRedirect("login?ck="+1);
		}else{
			resp.sendRedirect("login?ck="+2);
		}
	}// end doPost()
}// end class
