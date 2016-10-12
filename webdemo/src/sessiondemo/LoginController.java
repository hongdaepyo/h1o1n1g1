package sessiondemo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//RequestDispatcher dis = req.getRequestDispatcher("/sessionview/login.jsp");
		RequestDispatcher dis = req.getRequestDispatcher("/el_jstl/login.jsp");
		dis.forward(req, resp); 
	}
}// end class
