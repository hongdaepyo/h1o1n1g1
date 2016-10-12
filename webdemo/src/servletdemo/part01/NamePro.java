package servletdemo.part01;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NamePro")
public class NamePro extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//post방식일때 한글처리(파라미터 값을 받아 오기 전에 처리해준다)
		//req.setCharacterEncoding("UTF-8");
		String fname=req.getParameter("fname");
		req.setAttribute("fname", fname);
		
		RequestDispatcher dis=req.getRequestDispatcher("/servletview/part01/namePro.jsp");
		dis.forward(req, resp);
	}//end dopost()

}//end class
