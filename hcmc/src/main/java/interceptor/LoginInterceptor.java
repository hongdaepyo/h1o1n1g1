package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	static final String[] EXCLUDE_URL_LIST={""};
	
	public LoginInterceptor() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String reqUrl=request.getRequestURL().toString();
		for(String target : EXCLUDE_URL_LIST){
			if(reqUrl.indexOf(target)>-1){
				return true;
			}
		}
		
		/////////////////////////////////////////로그인 할 경우 비밀번호 처리////////////
		String uri=request.getRequestURI();
		uri=uri.substring(uri.lastIndexOf("/")+1);
		HttpSession session=request.getSession();
		Object chk=session.getAttribute("chk");
		System.out.println(chk);
		/*if(chk==null){
			session.setAttribute("msg", "로그인을 해주세요");
			response.sendRedirect("main.do");
			return false;
		}	*/	
		System.out.println(request.getSession().getAttribute("chk")+"인터셉터");
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
}
