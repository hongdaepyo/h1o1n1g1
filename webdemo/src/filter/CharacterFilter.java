package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*") /*모든페이지 적용:'/*' 특정페이지 적용: '/이름'*/
public class CharacterFilter implements Filter {
	
	//필터가 웹콘테이너에서 삭제될때 호출한다.
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
	
	//체인을 따라 다음에 존재하는 필터로 이동한다.
	//체인의 가장 마지막에는 클라이언트가 요청한 최종 자원이 위치한다.
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
		
		
	}
	
	//필터가 웹 콘테이너에 생성한 후 초기화할때 호출한다.(tomcat이 켜질때)
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}

}
