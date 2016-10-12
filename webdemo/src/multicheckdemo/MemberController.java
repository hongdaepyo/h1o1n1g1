package multicheckdemo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/multi")
public class MemberController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberDAO dao = MemberDAO.getInstance();
		ArrayList<MemberDTO> aList = dao.search();
		req.setAttribute("aList", aList);
		RequestDispatcher dis = req.getRequestDispatcher("/multicheckview/list.jsp");
		dis.forward(req, resp);
	}// end doGet()

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String[] str=req.getParameterValues("chk");
     MemberDAO dao=MemberDAO.getInstance();
     dao.deleteMethod(str);
     
     resp.sendRedirect("multi");
	}// end doPost()
}// end class








