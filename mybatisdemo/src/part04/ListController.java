package part04;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myList")
public class ListController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemDao dao=new MemDao();
		
		if(req.getParameterValues("chk")!=null){
			dao.deleteMethod(req.getParameterValues("chk"));
		}
		
		req.setAttribute("aList", dao.listMethod());
		RequestDispatcher dis=req.getRequestDispatcher("/view/list.jsp");
		dis.forward(req, resp);
	}//end doGet()
	
}//end class
