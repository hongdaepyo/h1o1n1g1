package part06;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sawonList2")

public class ListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmpDao dao=new EmpDao();
		
		req.setAttribute("aList", dao.listMethod());
		RequestDispatcher dis=req.getRequestDispatcher("/view/sawonList2.jsp");
		dis.forward(req, resp);
	}//end doGet()

}
