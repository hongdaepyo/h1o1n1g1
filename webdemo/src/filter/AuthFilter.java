package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class AuthFilter implements Filter {
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
 System.out.println("tes2");
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse)res;

		HttpSession session = request.getSession();

		if (session == null) {
			response.sendRedirect("login.xhtml");
			// or to pass values
			RequestDispatcher dis=request.getRequestDispatcher("login.xhtml");
			dis.forward(req, res);
			
		}

		chain.doFilter(req, res);
	}

	public void init(FilterConfig config) throws ServletException {
		// add init values
	}

	public void destroy() {
		// add code to release any resource
	}
}
